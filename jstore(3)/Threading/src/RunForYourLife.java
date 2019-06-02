public class RunForYourLife implements Runnable {
    private Thread t;
    private String threadName;
    private int jeda;

    public RunForYourLife(String name, int jeda){
        threadName = name;
        this.jeda = jeda;
        System.out.println(threadName + ", ready.");
    }
    @Override
    public void run() {
        System.out.println(threadName + ", go!");
        try{
            for(int i = 20; i>0; i--){
                System.out.println(threadName + " has passed checkpoint " + i);
                Thread.sleep(jeda);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        }
        System.out.println(threadName + " has finished!");
    }

    public void start (){
        System.out.println(threadName + ", set...");
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
