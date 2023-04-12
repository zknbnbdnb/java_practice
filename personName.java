package code;
import java.util.*;

class fi {
    fi(){
        med();
    }
    void med() {
        System.out.println("fi");
    }
}

class se extends fi {
    se(){
        med();
    }
    void med() {
        System.out.println("se");
    }
}

class an {
    an(){
        System.out.println("an");
    }
}

class bn extends an {
    bn(){
        System.out.println("bn");
    }
}

interface jk {
    int x = 40;
    int y = 20;
    void output();
}

class a implements jk {
    public void output() {
        System.out.println(x + y);
    }
}

class b implements jk {
    public void output() {
        System.out.println(x - y);
    }
}

class exam {
    public void show() {
        a classa = new a();
        b classb = new b();
        classa.output();
        classb.output();
    }
}

class personName{
    public static void main(String[] args){

        new se();
        new bn();
        // ע���ұ�������������

        exam ex = new exam();
        ex.show();

        int i;
        int a[] = new int[2];
        try {
            for (i = 0; i <= a.length; i++) {
                a[i] = 4*(i + 1);
            }
            System.out.println("����");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("�쳣");
        }finally {
            for (i = a.length - 1; i >= 0; i--) {
                System.out.println("a[" + i + "]=" + a[i]);
            }
            System.out.println("����");
        }

        int x = 1;
        int y = 2;
        int z = 3;
        y += z--/++x;
        System.out.println(y);
    }

}