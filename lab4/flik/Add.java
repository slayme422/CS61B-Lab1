package flik;

    public class Add implements Predicate{
        @Override
        public int apply(int a,int b) {
            return a + b;
        }
    }

