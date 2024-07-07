package core.practise;

class BookingApp{
    int totalSeats =10;

   public synchronized void book(int seats){
      if(seats<=totalSeats){
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
          totalSeats -= seats;
         System.out.println("Tickets booked successfully!!" + "Remaining Tickets :"+ (totalSeats));

      }else{
         System.out.println("Tickets not available!!"+"Remaining Tickets :"+ (totalSeats));
      }
   }
}


class BookingTask extends Thread{
   int seats;
  static BookingApp b= new BookingApp();
   public BookingTask(int seats){
      this.seats=seats;
   }

   public void run(){
      b.book(seats);
   }

}

public class MultiThreading {

   public static void main(String[] args){

       BookingTask bookingTask1=new BookingTask(7);
       BookingTask bookingTask2=new BookingTask(6);
      bookingTask1.start();
      bookingTask2.start();
   }


//    static class Job implements Callable {
//
//        @Override
//        public Object call() throws Exception {
//            System.out.println("Job start from "+Thread.currentThread().getName());
//            Thread.sleep(10000);
//            System.out.println("Job end from "+Thread.currentThread().getName());
//            return "Return from "+Thread.currentThread().getName();
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//
//        Job[] jobs= new Job[]{
//                new Job(),
//                new Job(),
//                new Job(),
//                new Job(),
//                new Job(),
//                new Job(),
//                new Job()
//        };
//
//        ExecutorService service = Executors.newFixedThreadPool(5);
//        Future<Object>[] futures = new Future[jobs.length];
//        for (int i = 0; i < jobs.length; i++) {
//            futures[i] = service.submit(jobs[i]);
//            System.out.println("After each submit call");
//            System.out.println("resFromThread: " + futures[i].get());
//        }
//        System.out.println("After for loop before shutdown");
//
////        // Retrieve the results from the Future objects
////        for (int i = 0; i < futures.length; i++) {
////            try {
////                Object result = futures[i].get(); // This call will block until the task is complete
////                System.out.println("Result from Job " + i + ": " + result);
////            } catch (ExecutionException e) {
////                e.printStackTrace();
////            }
////        }
//
//        service.shutdown();
//        System.out.println("After shutdown call");
//    }

//    static class Job implements Runnable{
//
//        @Override
//        public void run() {
//            System.out.println("Job start from "+Thread.currentThread().getName());
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Job end from "+Thread.currentThread().getName());
//        }
//    }
//
//    public static void main(String[] args){
//
//        Job[] jobs= new Job[]{
//                new Job(),
//                new Job(),
//                new Job(),
//                new Job(),
//                new Job(),
//                new Job(),
//                new Job()
//        };
//
//        ExecutorService service= Executors.newFixedThreadPool(5);
//        for(Job j: jobs){
//            service.submit(j);
//            System.out.println("After each submit call");
//        }
//        System.out.println("After for loop before shutdown");
//        service.shutdown();
//        System.out.println("After shutdown call");
//    }

}
