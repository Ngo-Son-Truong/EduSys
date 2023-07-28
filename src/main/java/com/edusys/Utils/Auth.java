
package com.edusys.Utils;

import com.edusys.Entity.NhanVien;


public class Auth {
    //Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
    public static NhanVien user = null; // duy trì user đăng nhập vào hệ thống
    // xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
    public static void clear(){
        Auth.user = null;
    }
    //Kiểm tra xem đăng nhập hay chưa
    //@return đăng nhập hay chưa
    public static boolean isLogin(){
        return Auth.user != null;
    }
    //Kiểm tra quyền
    public static boolean isManager(){
        return Auth.isLogin() && user.isVaiTro();
    }
}
