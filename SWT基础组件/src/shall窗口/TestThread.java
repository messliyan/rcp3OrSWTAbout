package shall����;
    
import java.awt.GradientPaint;
     
public class TestThread {
    
    public static void main(String[] args) {
  
         Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 616;
           
        Thread t1 = new Thread(){
            public void run(){
                while(true){
                     
                  
                }
 
            }
        };
        t1.start();
 
        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();
                    System.out.printf("t2 Ϊ%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n",gareen.name,gareen.name,gareen.hp);
 
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
 
            }
        };
        t2.start();
           
    }
        
}