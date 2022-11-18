package productmanagement;

import run.Main;

public class ViewProduct {


    public static void view() {
        /**
         * kiểm tra xem đã nhập sản phẩm?
         * phải có sản phẩm mới có thể xem sản phẩm
         */
        if ( Main.products.size() == 0 ) {
            System.out.println("You must have product's information first.");
            return;
        }

        System.out.println("The product(s) in the list: ");
        for (int i = 0; i < Main.products.size(); i++) {
            if ( Main.products.get(i) != null ) {
                System.out.println(Main.products.get(i));
            }
        }
    }

}
