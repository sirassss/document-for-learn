Code is clean if it can be understood easily – by everyone on the team. Clean code can be read and enhanced by a
developer other than its original author. With understandability comes readability, changeability, extensibility and
maintainability.
_____________________________________

## General rules

1. Follow standard conventions.
2. Keep it simple stupid. Simpler is always better. Reduce complexity as much as possible.
3. Boy scout rule. Leave the campground cleaner than you found it.
4. Always find root cause. Always look for the root cause of a problem.

## Design rules

1. Keep configurable data at high levels.

   > - high levels: là để các cấu hình chung của hệ thông ở các module cao nhất (VD: thông tin connect DB thì nên để trong file môi trường)
   > => giảm sự phụ thuộc giữa mã nguồn và dữ liệu cấu hình -> tăng tính linh hoạt
   > - low levels: là để các cấu hình chung của hệ thông ở các module thấp, các method, class cụ thể
   > => tạo kết dính, khó bảo trì về sau

2. Prefer polymorphism to if/else or switch/case.

   > if/else hay switch/case chỉ nên dùng trong các trường hợp đơn giản, không có tính mở rộng trong tương lai hoặc xử lý các trường hợp phức tạp mà đa hình không thể giải quyết

3. Separate multi-threading code.

   > nên tách các phần xử lý đa luồng riêng và phần xử lý logic nghiệp vụ riêng để dễ bảo trì về sau

4. Prevent over-configurability.

   > giảm thiểu sự phức tạp trong việc cấu hình, nhằm tránh việc người sau khó hiểu trong việc đọc cấu hình của lớp đó <br/>
   > VD: ta có thể đặt các cấu hình mặc định và hợp lý cho 1 class 

   ````java
   public class Person {
    private Boolean isLive = true; // đây là ví dụ cho việc giảm sự phức tạp
    private String name;
    Person(String name) {
    this.name = name;
    }
   }
   ````
5. Use dependency injection.
6. Follow Law of Demeter. A class should know only its direct dependencies.

   > 1 class chỉ nên biết về các phụ thuộc trực tiếp của nó, <br/>
   > và không nên truy cập vào các thành phần của các đối tượng khác mà được truyền vào thông qua các tham số hoặc thông qua các thuộc tính của đối tượng khác.<br/>
   > VD:

   ````java
   public class Person {
    private String name;
    private Address address;
    Person (String name, Address address) {
    this.name = name;
    this.address address;
    }
    public String printAddress() {
    return address.getStreet() + " " + address.getState();
    }
   }
   /*---------------------------*/
   public class Person {
    private String name;
    private Address address;
    Person (String name, Address address) {
    this.name = name;
    this.address address;
    }
    public String printAddress() {
    return address.printAddress(); // method này sẽ xử lý phần address in ra và thực hiện trong class Address để giảm sự phụ thuộc
    }
   }
   ````

## Understandability tips

1. Be consistent. If you do something a certain way, do all similar things in the same way.

   > đảm bảo tính nhất quán trong code, nếu đã làm 1 cách như vậy thì nên làm tất cả đề như vậy

2. Use explanatory variables.
3. Encapsulate boundary conditions. Boundary conditions are hard to keep track of. Put the processing for them in one
   place.

   > điều kiện biên ở đây là các điều kiện để tiếp tục thực hiên method<br/>
   > giữ sử dụng giao diện biên trong lớp hoặc các lớp cùng họ, nơi mà các giao diện đó được sử dụng, tránh trả về giao diện biên từ public API hoặc sự dụng giao diện biên như tham số của publc API<br>
   > VD giao diện biên: (Person) persons.get(id) // persons ở đây là Map
   > ta nên đóng gói 1 API từ bên thứ 3 để có thể dễ dàng hơn trong việc nâng cấp và maintain sau này

4. Prefer dedicated value objects to primitive type.

   > kiểu dữ liệu nguyên thủy ở đây ý là các kiểu dữ liệu có giá trị nguyên thủy không phải int-Integer, float-Float,
   ...<br/>
   > nên đóng gói các thuộc tính có chung tính chất thành value object để có thể dễ xử lý các thuộc tính nguyên
   thủy <br/>
   > VD: trong class order ta sẽ không viết các thuộc tính street, code, state,... mà sẽ đóng gói nó thành class address
   để xử lý và order sẽ tạo giá trị cho address

5. Avoid logical dependency. Don't write methods which works correctly depending on something else in the same class.

   > các method không nên quá phụ thuộc lẫn nhau cũng như phụ thuộc vào thuộc tính trong cùng 1 class

6. Avoid negative conditionals. `dễ hiểu hơn`

## Names rules

1. Choose descriptive and unambiguous names.
2. Make meaningful distinction.
3. Use pronounceable names.
4. Use searchable names.
5. Replace magic numbers with named constants.
6. Avoid encodings. Don't append prefixes or type information.

## Functions rules

1. Small.

   > nên viết khoảng 20 dòng<br/>
   > các khối trong điều kiện if/else, switch/case, do/while nên được viết trong 1 dòng, và dòng này nên là các method

2. Do one thing.

   > trong một method thì chỉ nên có các method có cùng mức độ trừu tượng bên dưới tên hàm<br/>
   > có nhiều mức độ trừu tượng trong một method sẽ làm cho method đó khó hiểu

3. Use descriptive names.
4. Prefer fewer arguments.

   > - có 1 đối số là lý tưởng và chỉ đứng sau method không có đối số
   > - có 2 lý do phổ biến để truyền 1 đối số vào 1 method 
   >    + khi bạn đặt câu hỏi về đối số đó 
   >    vd: isExists("myFile")
   >    + khi bạn có thể tác động lên đối số đó, biến đổi nó thành 1 cái khác rồi trả về
   > - tránh sử dụng đối số đầu ra

5. Have no side effects.
6. Don't use flag arguments. Split method into several independent methods that can be called from the client without
   the flag.
7. Tách biệt `mệnh lệnh` và `truy vấn` trong 1 method
8. Nên trả về `exception` thay vì các mã lỗi (ERROR_CODE)

   > - xử lý try/catch cũng là 1 nhiệm vụ => ta nên tách nó ra 1 method<br/>
   > - ta nên tách quá trình xử lý lỗi thành 1 phần riêng <br/>
   > - thay vì viết bắt nhiều ngoại lên thì ta lên tạo 1 ngoại lệ dùng chung và ngoại lệ đó sẽ được bắn ra với input là
   các ngoại lệ phải xử lý(catch các ngoại lệ muốn bắt và throw ra ngoại lệ mình định nghĩa)<br/>
   > - áp dụng special case pattern của fowler để có thể xử lý 1 số ngoại lệ, trường hợp đặc biệt
   > vd: thay vì trả về 1 employee null thì ta nên custom 1 class kế thừa từ employee là NULLEmployee để xử lý trường
   hợp `null`
   > - không nên trả về null:
   >   + nếu muốn trả về 1 giá trị null thì nên cân nhắc `ném ra 1 exception` hoặc áp dụng `SPECIAL CASE`
   >   + nếu gọi tới hàm trả về null từ 1 API của bên thứ 3 thì nên đóng gói các method đó và `ném ra 1 exception` hoặc
         áp dụng `SPECIAL CASE`
   > - không nên truyền giá trị null

9. Trong 1 method dài: không nên có nhiều hơn 1 `return` hay `break`, `continue` trong vòng lặp


## Comments rules

1. Always try to explain yourself in code.
2. Don't be redundant.
3. Don't add obvious noise.
4. Don't use closing brace comments.
5. Don't comment out code. Just remove.
6. Use as explanation of intent.
7. Use as clarification of code.
8. Use as warning of consequences.

## Source code structure

1. Separate concepts vertically.
2. Related code should appear vertically dense.
3. Declare variables close to their usage.
4. Dependent functions should be close.

   > hàm phụ thuộc nên nằm bên dưới nếu có thể 

5. Similar functions should be close.
6. Place functions in the downward direction.
7. Keep lines short.
8. Don't use horizontal alignment.
9. Use white space to associate related things and disassociate weakly related.
10. Don't break indentation.

## Objects and data structures

1. Hide internal structure.

   > ẩn đi chi tiết các cài đặt là sự trừu tượng hóa chứ không phải thêm 1 tầng chứa các method vào giữa các biến <br/>
   > nó chỉ nên trình bày ra các giao diện trừu tượng và cho phép người dùng thao tác trên `bản chất` dữ liệu, mà không
   biết đến các cài đặt bên trong <br/>
   > lựa cọn tệ nhất là sử dụng các method getter và setter 1 cách vô tư

2. Prefer data structures.

   > 1 `đối tượng` sẽ ẩn đi chi tiết về dữ liệu của nó đằng sau sự trừu tượng và cung cấp các hàm để thao tác với dữ liệu đó <br/>
   > -> thêm 1 lớp mới dễ dàng mà không phải sửa hàm đã có <br/>
   > 1 `cấu trúc dữ liệu` cho thấy chi tiết dữ liệu và không cung cấp các hàm có ý nghĩa nào <br/>
   > -> thêm 1 hàm mới dễ dàng mà không phải thay đổi cấu trúc dữ liệu đã có <br/>
   > -> không nên quá coi trọng 1 kỹ thuật (thủ tục hoặc hướng đối tượng)

3. Avoid hybrids structures (half object and half data).

   > DTO (Data Transfer Object) là 1 cấu trúc dữ liệu dễ thấy nhất

4. Should be small.
5. Do one thing.
6. Small number of instance variables.
7. Base class should know nothing about their derivatives.
8. Better to have many functions than to pass some code into a function to select a behavior.

   > Nên tách các functions ra làm các hành vi cụ thể

9. Prefer non-static methods to static methods.

## Tests

1. One assert per test.
2. Readable.
3. Fast.
4. Independent.
5. Repeatable.

## Code smells

1. Rigidity. The software is difficult to change. A small change causes a cascade of subsequent changes.
2. Fragility. The software breaks in many places due to a single change.
3. Immobility. You cannot reuse parts of the code in other projects because of involved risks and high effort.
4. Needless Complexity.
5. Needless Repetition.
6. Opacity. The code is hard to understand.

> Nguyên tắc Demeter: 1 method f() của class C chỉ nên gọi tới các method sau đây<br/>
> 1. các method của class C<br/>
> 2. các method của đối tượng mà f() tạo ra<br/>
> ````java
> public class C {
>   public A f() {
>   return new A();
>   }
>   public static void main() {
>   C c = new C();
>   A a = c.f();
>   a.k();      /** NÊN*/
>   c.f().k();   /** KHÔNG NÊN*/
>   }
> }
> ````
> 3. các method của đối tượng là tham số của f()<br/>
> 4. các method của đối tượng được dữ trong 1 biến thưc thể của class C
> 5. **KHÔNG** nên gọi các method của đối tượng nằm ngoài nhóm liên quan trực tiếp đến nó, mà ta nên gọi thông qua 1 đối tượng khác
> ````java
> class Student {
>   private List<Course> course;
>   public double getTotalCredit() {
>   double total = 0;
>   course.forEach(n -> total += n.getCredit()); /** KHÔNG NÊN*/
>   }
> }
> class Course {
>   public double getCredit(){}
> }
> class StudentService {
>   public double getTotalCredit() {
>   Student student = new Student();
>   List<Course> course = student.getCourses();
>   double total = 0;
>   course.forEach(n -> total += n.getCredit()); /** NÊN*/
>   }
> }
> ````
 
> Khi tách 1 hàm :<br>
> -> ta có 2 hàm nhưng chúng lại sử dụng cùng vài biến => bị trùng biến :(<br>
> -> để biến thành các hằng chung của class -> lớp không còn được liên kết chặt chẽ nữa, có nhiều hằng mà lại chỉ có và hàm dùng chung<br>
> -> tạo ra 1 lớp riêng<br>
> ==> tách một hàm lớn thành các hàm nhỏ hơn thường là cách để chúng ta chia các lớp lớn thành các lớp nhỏ


> Nên phân tác quá trình khởi động ban đầu (the startup process) khi ứng dụng được xây dựng - những phần phụ thuộc được
> nối với nhau với quá tình chạy thực thi (the runtime logic) diễn ra sau giai đoạn khởi động <br>
> -> chính là tách biệt `xây dựng `và `sử dụng` <br>
> -> ứng dụng không có thông tin về quá trình xây dựng, nó chỉ đơn giản là kỳ vọng rằng mọi thứ được xây dựng đúng đắn <br>
> nếu như tỉ mỉ trong việc xây dựng hệ thống mạnh thì ta sẽ không bao giờ nên để cho các thành tố đặc thù tiện lị dẫn
> đến phá vỡ tính module hóa
> 

- có thể tách các điều kiện if else thành biểu đồ bằng cách tạo ra Map và đưa các công việc đó vào value của Map đó
  - ví dụ: có thể dùng các functional để thực hiện

