package extendThread.extended;

/**
 * Created by Administrator on 2018/3/23.
 */
public class Father extends FathersF {

    public void kk(){
        System.out.println("this is Father");

        cc();
    }

    class InnerFather{

        private void kk(){
            Father.this.kk();
            System.out.println("this is inner kk");
        }

        public void ll(){
            this.kk();
            Father.this.kk();
        }
    }


    public static void main(String[] args) {
        Father f=new Father();
        InnerFather innerFather=f.new InnerFather();
        innerFather.kk();
    }

}
