# OOP

***

# Inheritance (Kế thừa)

## Core concept

* Là khả năng cho phép ta xây dựng một lớp mới dựa trên các định nghĩa của một lớp đã có.
* Có thể chia sẻ hay mở rộng các đặc tính sẵn có mà không phải tiến hành định nghĩa lại.
* Là một lớp (class) có được các thuộc tính của một lớp khác. Các thuộc tính đó có thể là một phương thức (method) hoặc
  một trường (field) nào đó.
* Lớp được kế thừa sẽ được gọi chung là lớp cha, còn lớp kế thừa sẽ được gọi chung là lớp con.


#### Advantage:

* Tăng khả năng tái sử dụng
* Các class con sẽ tuân theo 1 giao diện chuẩn
* Hạn chế dư thừa và hỗ trở mở rộng code


***

# Polymorphism (Đa hình)

## Core concept

* Tính đa hình cho phép một phương thức thực thi những hành vi khác nhau theo hai hướng:
sử dụng phương thức ghi đè (method overriding) hoặc phương thức nạp chồng (method overloading).

### Compile time Polymorphism (Đa hình tĩnh):

  ```java
  	public class Demo {

  	public void add(Integer a, Integer b) {}
  	public void add(String a, String b) {}

   }
   ```

* Nạp chồng phương thức (Function Overloading) cho phép sử dụng cùng một tên gọi cho các hàm “giống nhau” (có cùng mục
  đích). Nhưng khác nhau về kiểu dữ liệu tham số hoặc số lượng tham số.

* Ngay khi dịch thì trình biên dịch đã biết chính xác hàm nào được gọi rồi
* Vẫn giữ nguyên được ý nghĩa của method nhưng cách thực hiện thì khác nhau

### Runtime Polymorphism (Đa hình động)

  ```java
   public class Animal {
   public void move(Integer a) {}
   }

   public class Dog extends Animal {
   public void move(Integer a) {}
   }

   public class Cat extends Animal {
   public void move(Integer a) {}
   }
   ```

* Ghi đè phương thức (Function Overriding) cho phép class con ghi đè phương thức của class cha, giống nhau về tham số
* Lúc biên dịch chương trình chưa biết được hàm nào sẽ chạy

      - Ta không thể biết đối tượng đó sẽ LÀM gì nếu không chỉ rõ đối tượng đó LÀ gì!!!
      - Hành động phát ra tiếng của chó và mèo, tuy nhiên, bạn sẽ không thể biết thực hiện như thế nào cho đến khi biết
      đối tượng là con chó hay mèo để thực hiện kêu “meo meo” hay là sủa “gâu gâu”.

#### Advantage:

      - Viết code linh hoạt hơn
      - Thực hiện cùng 1 thông điệp theo các cách khác nhau
      => code không bị trùng lặp ( overriding - trường hợp class extends class )
      => cùng ý nghĩa nhưng cách thực hiện khác nhau ( overloading )

***

# Abstraction (Trừu tượng)

## Core concept

> Mọi thứ hoạt động trong đối tượng như black box, chỉ có thể nhìn thấy input và output không thể biết process như thế nào

* Trừu tượng tập trung vào các đặc tính thiết yếu của đối tượng, tùy thuộc vào góc độ của người nhìn.

      - Ưu điểm chính của thừa kế là nhờ có nó ta mới có được đa hình (polymorphism), và nhờ đa hình mà ta có trừu tượng (abstract).
      - Là thứ mà các nhà phát triển muốn sử dụng càng nhiều càng tốt
      - Cho phép ta làm việc với các thành phần khác mà cần quan tâm chúng xây dựng như thế nào

* Tạo ra 1 layer đơn giản hơn để sử dụng nhằm ẩn đi những thứ phức tạp bên trong.
* Ý nghĩa nằm ở mặt thiết kế hệ thống, tạo ra các ràng buộc bắt buộc để hệ thống logic hơn:

      - Gom những đặc điểm giống nhau của các đối tượng cụ thể lại thành 1 khái niệm trừu tượng

* Trừu tượng chỉ là một khái niệm, và có nhiều kỹ thuật để hiện thực khái niệm này trong OOP:

  - Function/operator overloading
  - Sử dụng thừa kế với các abstract method của abstract class
  - Sử dụng interface
    + có thể sử dụng các method trong interface mà không phải quan tâm nội dụng hay khía cạch khác của lớp đó
    + abstract class có thể làm được thứ mà interface làm nhưng có 1 điều không được đó là sự đơn giản
  > => overloading, interface, overriding, abstract class ... chỉ là những công cụ

> Để hiểu tính trừu tượng là gì thì ta phải đặt câu hỏi **TẠI SAO TA CẦN NÓ?** chứ không phải **NÓ LÀ GÌ?**_
#### Advantage:

* Đơn giản hóa việc sử dụng chức năng của đối tượng
* Giảm sự phụ thuộc giữa các đối tượng
* Giúp cho chương trình nó được sắp xếp 1 cách có logic và có ý nghĩa >> dễ hiểu >> dễ bảo trì, sửa chữa

       Khi 1 đứa nào đó đọc vào thấy, À! đối tượng này là con heo và nó thuộc lớp động vật thì chắc chắn nó sẽ có
       những thuộc tính này hành vi này!

* Giúp tái sử dụng mã nguồn


***

# Encapsulation (Đóng gói)

## Core concept

* Giúp kiểm soát việc truy cập các thành phần bên trong lớp, để tránh các biến này thay đổi không mong muốn

      - Các biến non-static sẽ được coi là các thuộc tính của đối tượng. 
      Mỗi thuộc tính sẽ giữ giá trị của một trạng thái nào đó của đối tượng
      
      speed -> là thuộc tính vận tốc
      ismoving -> là thuộc tính đang di chuyển
      => Nếu speed > 0 thì ismoving = true
      => Hai trạng thái này có mỗi liên hệ chặt chẽ với nhau

* Để đảm bảo toàn vẹn giữ liệu, hay nói cách khác là giữ trạng thái của các đối tượng được lưu trữ 1 cách đúng đắn
  là bạn phải kiểm soát được `ai có thể thay đổi các thuộc tính đó`

* Tính đóng gói cho phép ẩn đi các chi tiết bên trong của một đối tượng và chỉ cho phép truy cập đến chúng thông qua các
  giao diện công khai (public interface).

  > Điều này giúp tăng tính bảo mật của mã nguồn và làm cho mã nguồn dễ bảo trì hơn.

* Việc sử dụng tính đóng gói giúp đảm bảo rằng các giá trị của một đối tượng chỉ được thay đổi thông qua các phương thức
  được định nghĩa công khai của đối tượng đó.

* Data Abstraction: một class sẽ có 2 phần gồm Abstraction layer và Implementation

     ````java
       /**
       * Với phần code này thì 
       * Abstraction layer: là phần public ra bên ngoài sử dụng
       * Implementation: là toàn bộ của class đó
       * Trong ví dụ sau:
       * name, getAge() là Abstraction layer
       */
       public class Person {
        public String name = "Lam";
        private int birthDay = 2000;
       
        public int getAge() {
        return 2023 - birthDay;
        }
       }
     ````
* Trong Java, tính đóng gói được thể hiện thông qua phạm vi truy cập (access modifier)

### Rule

* Càng đóng càng tốt: tức là hạn chế khả năng thay đổi từ bên ngoài nhất có thể

      - Nên dùng protected khi các class con CẦN dùng tới
      - Dùng public khi 1 lớp bên ngoài CẦN tới thuộc tính/ phương thức đó

* Tránh cho phép truy cập trực tiếp tới các thuộc tính

      - Nên để các thuộc tính là private và truy cập thông qua getter và setter
      => giúp kiểm soát được tính hợp lệ của các thuộc tính
      - Đóng gói ở đây là ẩn đi các thuôc tính(không có nghĩa là nó sẽ được thao tác thông qua getter hay setter)
      có nghĩa là nó sẽ ẩn đi cấu trúc dữ liệu của class và chỉ public ra nhưng hàm, những triển khai của nó

* Ưu điểm của việc đóng gói là bạn sẽ không bị ràng buộc với việc lựa chọn 1 nhà cung cấp API với thiết kế đặc thù nào
  đó

  > -> đóng gói còn có nghĩa là tách hàm(class), đóng gói trong 1 class, method<br>
  > -> mục đich che giấu thông tin, hạn chế truy cập vào các thành phần bên trong class, tránh các lỗi không mong muốn
  > khi viết chương trình `HOÀN TOÀN KHÔNG CÓ Ý NGHĨA VỀ MẶT BẢO MẬT`



# Conclusion

* `Đối tượng` : Nó được coi là một thể hiện của một lớp.
* `Lớp` : Nó là một tập hợp các đối tượng cùng loại. Một bộ dữ liệu và mã hoàn chỉnh của một đối tượng tạo ra một kiểu dữ
  liệu do người dùng định nghĩa bằng cách sử dụng một lớp.
* `Trừu tượng hóa dữ liệu và đóng gói` : Trừu tượng hóa chính là phương pháp ẩn chi tiết và thể hiện các tính năng thiết
  yếu. Đóng gói là một phương pháp gom dữ liệu và chức năng thành một đơn vị.
* `Kế thừa` : Kế thừa là một kỹ thuật thu nhận các tính năng của các đối tượng từ một lớp này sang các đối tượng lớp khác.
  Nói cách khác, nó giúp tạo ra một lớp mới từ lớp hiện có.
* `Đa hình` : Đa hình cung cấp một phương pháp tạo nhiều dạng của hàm bằng cách sử dụng một tên hàm duy nhất.
* `Liên kết động` : Nó xác định rằng mã được liên kết với một thủ tục cụ thể không được biết cho đến thời điểm nó được gọi
  trong thời gian chạy chương trình.
* `Message passing`: Khái niệm OOP cho phép tương tác giữa các lớp khác nhau bằng cách truyền và nhận dự liệu.







