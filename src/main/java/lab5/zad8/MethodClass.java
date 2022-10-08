package lab5.zad8;

import java.util.concurrent.locks.ReentrantLock;

    public class MethodClass implements AutoCloseable{
        private ReentrantLock lock;

        public MethodClass(ReentrantLock lock){
            this.lock = lock;
        }

        public void lock() {
            lock.lock();
            System.out.println("locked");
        }

        @Override
        public void close(){
            try {
                lock.unlock();
                System.out.println("unlocted");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
