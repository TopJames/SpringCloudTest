package extendThread.extended;

/**
 * Created by Administrator on 2018/3/23.
 */
public class FathersF {

    public void kk(){
        System.out.println("this is FathersF");
    }

    public void cc(){
        System.out.println("this is FathersF cc");
        dd();
    }

    public  void dd(){
        System.out.println("this is FathersF dd");
    }

    class InnerFather{

        private void kk(){
            FathersF.this.kk();
            System.out.println("this is inner kk");
        }

        public void ll(){
            this.kk();
            FathersF.this.kk();
        }
    }


    public static void main(String[] args) {
        FathersF f=new FathersF();
        InnerFather innerFather=f.new InnerFather();
        innerFather.kk();
    }

}
