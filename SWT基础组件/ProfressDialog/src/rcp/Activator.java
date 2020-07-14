package rcp;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.springframework.context.ApplicationContext;

import com.norcp.example.module.f.service.api.IUserService;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "RCP"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	// The BundleContext instance
		private static BundleContext context;
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		this.context = context;
		System.out.println(context);
		System.out.println("----------f-module----------");	
		
		ApplicationContext fcontext = 
		BundleSpringBeanUtils.getApplicationContext(context, 
		"com.norcp.example.module.f");
		System.out.println("ApplicationContext-:"+fcontext);	
		//System.out.println("userDao:"  + fcontext.getBean("userDao"));
		//System.out.println("groupDao:"+	fcontext.getBean("groupDao"));
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	/**
	 * @return
	 */
	public static IUserService getIUserService() {
		IUserService service =  (IUserService) BundleContextServiceUtils.getService(context, IUserService.class);

		
		while(service==null) {
			try {
				Thread.sleep(500);							
				service =  (IUserService) BundleContextServiceUtils.getService(context, IUserService.class);				
				System.out.println("service:"+service);	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return service;
	}
public static void main(String[] args) {
		
		System.out.println(getIUserService());
	}
}
