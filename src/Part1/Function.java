package Part1;

public class Function {
	
//bai 1.	Viết hàm liệt kê tất cả các số nguyên tố nhỏ hơn n. 
public static boolean SoNgTo(int n) {
	if(n<2) {
		return false;
	}
	for(int i=2;i<=Math.sqrt(n);i++) {
		if(n%i==0) {
			return false;
		}
	}
	return true;
}

public static void LKSoBehonn(int n) {
	for(int i=2;i<n;i++) {
		if(SoNgTo(i)) {
			System.out.print(i+" ");
		}
	}
}

//bai 2.	Viết hàm liệt kê n số nguyên tố đầu tiên.
public static void LKSoNgto1st(int n) {
	int dem=0;
	int so=2;
	
	while(dem < n) {
		if (SoNgTo(so)) {
			System.out.print(so +" ");
			dem++;
		}
		so++;
	}
}

//bai 3.	Viết hàm tất cả các số nguyên tố có 5 chữ số.
public static void LKSoNgTo5So(int n) {
	for(int i = 10000; i <= 99999;i++) {
		if (SoNgTo(i)) {
			System.out.print(i + " ");
		}
	}
}

//bai 4.	Viết hàm phân tích số nguyên n thành các thừa số nguyên tố.
public static void SoNgThanhSoNgTo(int n) {
	 for (int i = 2; i <= n; i++) {
	        while (n % i == 0) {
	            System.out.print(i + " ");
	            n = n / i;
	        }
	    }
}

//bai 5.	Viết hàm tính tổng các chữ số của một số nguyên n.
public static int TTsoNgTo(int n) {
    int tong=0;
    while (n > 0) {
        tong += n % 10;
        n /= 10;
    }
    return tong;
  }

//bai 6.	Viết hàm tìm các số thuận nghịch có 6 chữ số
public static boolean ktraSoThuanNghich(int n) {
    int original = n;
    int reverse = 0;

    while (n > 0) {
        int digit = n % 10;
        reverse = reverse * 10 + digit;
        n /= 10;
    }

    return original == reverse;
}

public static void ThuanNghich6So() {
    for (int i = 100000; i <= 999999; i++) {
        if (ktraSoThuanNghich(i)) {
            System.out.print(i + " ");
        }
    }
}

//bai 7 Liệt kê các số Fibonacci nhỏ hơn n
public static void FiboBeHonn(int n) {
	int a=0;
	int b=1;
	
	while(a<n) {
		if(SoNgTo(a)) {
			System.out.print(a+" ");
		}
		int c=a+b;
		a =b;
		b= c;
	}
}
}
