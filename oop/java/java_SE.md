## ArrayList:

- mặc định có khả năng tăng 1.5 so với kích thước ban đầu nếu quá độ dài
- có thể set initialCapacity cho nó, và mặc định nó sẽ có số lượng là initialCapacity và khi đến giới hạn sẽ tự động
  tăng với kích thước bằng với initialCapacity

- Bộ nhớ stack không được quản lý của GC và cũng có lưu địa chỉ của primitive variable

## HashSet

- luôn tạo ra 1 HashMap đi kèm để lưu giá trị
- tạo 1 collection dùng hashtable để lưu trữ, sử dụng cơ chế băm (hashing)
- có thể chứa null
- HashMap được ưa thích trong các ứng dụng đơn luồng (single-thread). Nếu bạn muốn sử dụng HashMap trong ứng dụng đa
  luồng (mulit-thread),
  có thể thực hiện bằng cách sử dụng phương thức Collections.synchronizedMap().
- Mặc dù HashTable có để sử dụng trong các ứng dụng đa luồng (multi-thread), nhưng ngày nay nó ít được sử dụng. Bởi vì,
  ConcurrentHashMap là lựa chọn tốt hơn HashTable.

## Lambda:

- không tên, không phạm vi truy cập và không định nghĩa kiểu trả về
- có thể truy cập bất kỳ biến final, static hoặc biến chỉ được gán một lần.
- có thể thay đổi static variables ở trong body của lambda
- bản chất của lambda là vừa tạo lớp và tạo đối tượng luôn
- tạo đối tượng lambda ở đâu thì địa chỉ của đối tượng đó gắn với class đó
- có thể được định nghĩa là 1 hàm ẩn danh, cho phép chuyển các phương thức làm đối số
- Biểu thức Lambda throw một lỗi biên dịch, nếu một biến được gán một giá trị lần thứ hai.

## Method references:

- Method References là cú pháp viết tắt của method để thay thế cho Lambda
- Tham chiếu đến một static method – Class::staticMethod
- Tham chiếu đến một instance method của một đối tượng cụ thể – object::instanceMethod
- Tham chiếu đến một instance method của một đối tượng tùy ý của một kiểu cụ thể – Class::instanceMethod
- Tham chiếu đến một constuctor – Class::new

## Functional interface:

- có thể có các method của Object();
- có thể coi là hình dạng của method và implement của nó có thể thực hiện bằng nhiều cách (tạo anonymous class như trên,
  dùng class riêng biệt, dùng lambda expression, method reference)

## instanceof

- chỉ kiểm tra được instance đã được khởi tạo đối tượng

## generic & wildcard

- wildcard: là ký tự `?` đại diện cho 1 `Type` không biết nào đó
    - không thể tham gia toán tử new
- generic:
    - chỉ lưu được 1 loại đối tượng
    - kiểm tra dữ liệu chặt chẽ ở compile-time chứ không phải runtime mới bắn lỗi, giúp kiểm soát lỗi dễ dàng hơn
    - hạn chế ép kiểu thủ công không an toàn
    - support viết thuật toán sử dụng nhiều, dễ thay đổi
    - không thể gọi Generics bằng kiểu dữ liệu nguyên thủy
    - không thể tạo instances của kiểu dữ liệu Generics, thay vào đó sử dụng reflection từ class
    - không thể sử dụng static cho Generics
    - không thể ép kiểu hoặc sử dụng instanceof.
    - không thể overload cùng đối tượng nhưng khác generic type
    - không thể extends trực tiếp hoặc gián tiếp `Throwable`

```java
public static <T extends Exception, J> void execute(List<J> jobs) {
try {
for (J job : jobs)
// ...
} catch (T e) {   // compile-time error
// ...
}
}
class Parser<T extends Exception> {
public void parse(File file) throws T {     // OK
// ...
}
}
```

## Serialization & Deserialization

- serialization(tuần tự hóa) trong java là một cơ chế để ghi trạng thái của một đối tượng vào một byte stream.
- deserialization thì ngược lại
- nếu là mỗi quan hệ is a thì class con sẽ vẫn serialized được nếu class cha có implement serializable
- nếu là mối quan hệ has a thì các thuộc tính của class phải đểu implement serializable thì class đó mới serialized được
- các thuộc tính static sẽ không serialized được vì nó không thuộc lớp

## Input và Output

- Input là đọc từ bên ngoài vào và sẽ có phương thức read
- Output là xuất từ chương trình ra và sẽ có phương thức write
- `InputStream`: được sử dụng để đọc dữ liệu từ một nguồn (source).
- `OutputStream`: được sử dụng để ghi dữ liệu đến đích (destination).
- ByteArrayOutputStream: sử dụng write() để ghi vào bộ đệm và dùng writeTo() để ghi vào stream khác(fileStream,
  objectStream)

## Wrapper class and primitive:

- `Integer`: có khoảng cache từ -128 -> 127, Long cũng vậy
- `primitive` nhanh hơn và tốn ít chi phí hơn `wrapper` nên chỉ dùng wrapper khi cần sử dụng `collection`
- cân nhắc autoboxing và unboxing vì nó khá tốn chi phí

## Mutable and Immutable:

- `Mutable Object`: khi khởi tạo 1 đối tượng, tức ta có 1 tham chiếu tới 1 thể hiện của 1 lớp, thì trạng thái của đối
  tượng
  có thể thay đổi được sau khi việc khởi tạo đối tượng thành công. Trạng thái đối tượng ở đây có thể là các trường thông
  tin mà đối tượng đó nắm giữ. Ví dụ: tên, tuổi của 1 đối tượng sinh viên chẳng hạn. Điều này có nghĩa là, bạn vừa có
  thể
  get() vừa có thể set() giá trị.
- `Immutable Object`: khi khởi tạo 1 đối tượng, thì trạng thái của tối tượng đó không thể thay đổi được sau khi việc
  khởi
  tạo đối tượng thành công. Điều này có nghĩa là, bạn chỉ có thể get() mà không thể set().

## String:

- `String` có tính đối tượng và vừa có tính nguyên thủy (primitive).
- `string literal`: là 1 chuỗi các ký tự vd: String ex = "Hello"; và được chứa trong một bể chứa (common pool). Như vậy
  hai
  string literal có nội dung giống nhau sử dụng chung một vùng bộ nhớ trên `stack`, điều này giúp tiết kiệm bộ nhớ.
- Khi chúng ta tạo chuỗi với toán tử new (), nó được tạo ra trong heap và không được thêm vào trong `String pool`. Trong
  khi String được tạo bằng cách sử dụng `literal` được tạo ra trong String pool và tồn tại trong vùng `PermGen` của
  heap.
- `String.intern()`: đưa 1 đối tượng String vào pool
- `StringBuilder`: nhanh hơn String trong cộng chuỗi nhưng bản chất vẫn là 1 array cho nên cần xem nếu muốn đạt hiệu
  suất tối ưu thì nên có `capacity` hợp lý

## Stream:

- có cơ chế Lazy Evaluation, duyệt theo từng luồng(filter->map->filter->) chứ không duyệt theo từng đoạn(filter), nếu
  như 1 luồng đã terminate thì các phần tử sau sẽ không được duyệt nữa
- VD: có 4 pt nhưng đến pt thứ 3 đã có kết quả thì pt thứ 4 sẽ không duyệt

## Annotation:

- là 1 loại siêu văn ban
- `Annotation` không trực tiếp ảnh hưởng đến việc thực hiện các mã, một số loại chú thích thực sự có thể được sử dụng
  cho mục đích đó.
- Cần sử dụng kỹ thuật lập trình Reflection để có thể truy vấn thông tin siêu dữ liệu (metadata information) và quyết
  định hành động thích hợp để thực hiện trong ngữ cảnh cụ thể.
- `@Inherited`: annotation đánh dấu 1 annotation và nếu class cha có annotation này thì lớp con cũng được kế thừa

## Enum:

- Có thể dùng `equal` lẫn `==` để so sánh
- chỉ có thể implements interface không thể extend class
- Có thể định nghĩa class cho constant field của enum

## pass by value

- `Trong Java chỉ có truyền tham trị`, không truyền tham trị tham chiếu. Điều này có nghĩa là một bản sao của biến được
  tạo ra và phương thức nhận bản sao đó. Các nhiệm vụ được thực hiện trong phương thức không ảnh hưởng đến đối tượng
  gọi.

## Heap & Stack

- stack: sử dụng cơ chế LIFO
- Khi run app máy tính sẽ cấp cho 1 phần bộ nhớ của RAM để JVM chia thành 2 phần là heap và stack
- Các objects trong Heap đều được truy cập bởi tất cả các các nơi trong ứng dụng, bởi các threads khác nhau.
- Các giá trị đươc lưu trong stack chỉ có phạm vi trong 1 thread và giải phóng khi lời gọi hàm kết thúc
- Stack lưu các biến nguyên thủy (primitive) và biến tham chiếu đến đối tượng trong heap(reference) được khai báo trong
  hàm
- Heap được phân làm 2 loại Young-Generation, Old-Generation
- dùng -Xms và -Xmx để định nghĩa dung lượng bắt đầu và dung lượng tối đa của bộ nhớ heap. Stack thì dùng -Xss

## Switch-case:

- Các giá trị trong mỗi câu lệnh case phải là các giá trị hằng số hoặc hằng số tại thời điểm biên dịch (compile-time
  constant) và có
  cùng kiểu dữ liệu với giá trị trong switch.

## Static:

- khối static chạy lúc compile-time, biến và method static được tải lúc compile-time
- Biến static được lưu trữ trong bộ nhớ static riêng.
- method static không thể bị ghi đè, kỹ thuật đè (overriding) phương thức được dựa trên quá trình gán (binding) động khi
  runtime (khi chương trình đang chạy) và những phương thức static được gán tĩnh trong thời gian biên dịch.
- phương thức static được ràng buộc với class, còn phương thức instance được ràng buộc với đối tượng

## Final:

- Phương thức final có thể được kế thừa nhưng không thể bị ghi đè
- Tham số trong method final cũng không thể bị thay đổi

## JVM:

- JVM gồm 4 nhiệm vụ chính: Load code, Verifies code, Executes code, Provides runtime enviroment.

## Interface:

- Interface là một kỹ thuật để thu được tính trừu tượng hoàn toàn và đa kế thừa trong Java.
- Một interface không phải là một lớp. Viết một interface giống như viết một lớp, nhưng chúng có 2 định nghĩa khác nhau.
  Một lớp mô tả các thuộc tính và hành vi của một đối tượng. Một interface chứa các hành vi mà một class triển khai.
- Java Compiler thêm từ khóa public abstract trước phương thức của interface và các từ khóa public static final trước
  các thành viên dữ liệu.
- Một interface không chứa bất cứ hàm Contructor nào.
- Sử dụng Interface khi bạn muốn tạo dựng một bộ khung chuẩn gồm các chức năng (method/ function) mà tất cả module/
  project cần phải có. Các module phải implements tất cả chức năng đã được định nghĩa.
- Nói về Abtract Class và Interface, đôi khi bạn sẽ gặp một số cách gọi: Khi một class extend một class/ abtract class
  thì có nghĩa là ta đang thể hiện mối quan hệ is-a (là), còn khi implement một interface, thì ta đang thể hiện mối quan
  hệ has-a (có, hay thực hiện).
- 1 class implements 2 interface có 2 default method giống nhau thì sẽ báo lỗi. có thể fix: [nameInterface]
  .super.nameMethod() bên trong method override
- 1 method của class và 1 default method của interface khi được override bởi 1 class thì method của class sẽ được ưu
  tiên
- có thể gọi static method của interface từ lớp đã triển khai interface đó
- Mục đích của interface là cung cấp sự trừu tượng đầy đủ (100% abstract), trong khi mục đích của abstract class là cung
  cấp một phần trừu tượng hóa (<100% abstract). Điều này vẫn đúng. Interface giống như một kế hoạch chi tiết cho lớp của
  bạn, với việc giới thiệu các phương thức mặc định, chúng ta có thể thêm các tính năng bổ sung trong các interface mà
  không ảnh hưởng đến các lớp implement hay end user.

## implement interface:

- Các checked exception không nên được khai báo trong phương thức implements, thay vào đó nó nên được khai báo trong
  phương thức interface hoặc các lớp phụ được khai báo bởi phương thức interface.
- Signature (ký số) của phương thức interface và kiểu trả về nên được duy trì khi ghi đè phương thức (overriding method)
  .
- Một lớp triển khai chính nó có thể là abstract và vì thế các phương thức interface không cần được triển khai.
- Đa kế thừa không được hỗ trợ thông qua lớp. Nhưng nó được hỗ trợ bởi Interface bởi vì không có tính lưỡng nghĩa khi
  trình
  triển khai được cung cấp bởi lớp Implementation.

## marker(Tagging) interface

- là interface trống không định nghĩa method cũng như field nào
- có thể thay thế bằng annotation trong vài mục đích
- là 1 interface cho nên nó vẫn có tính kế thừa, 1 class triển khai nó thì vẫn là `is a` còn annotation thì chỉ có thể
  đánh dấu trên 1 class, interface không có tính kế thừa
- có thể sử dụng type check lúc compile time khi là tham số
- marker interface trong Java được sử dụng để chỉ ra một cái gì đó cho complier, JVM hoặc bất kỳ công cụ nào khác.
- mục đính:
    + tạo cha chung cho 1 cụm interface
    + Thêm một kiểu dữ liệu tới một class: Đó là khái niệm tagging.
      Một class mà triển khai một tagging interface không cần định nghĩa bất kỳ phương thức nào, nhưng class trở thành
      một kiểu interface thông qua tính đa hình (polymorphism).
    + Thực hiện một số pre-processing trên các class, đặc biệt hữu dụng để phát triển các API và Framework giống như
      Sping, Struts.
    + Giúp cho code coverage và build tools để find bug dựa trên một behavior cụ thể của marker interface.
      vd: Serializable, Cloneable, Remote,...

Serializable: là 1 marker interface và là 1 đại diện cho đối tượng có thể tuần tự hóa sang các mảng byte và ngược lại

## Upcasting và Downcasting

- là cơ chế ép kiểu từ cha sang con(down) và từ con sang cha(up)

## Exception:

- Khi một lỗi xảy ra trên một method, method đó sẽ tạo ra một object và đưa nó vào Runtime System
- Nếu không có method nào có xử lý ngoại lệ phù hợp thì Thread mà đang thực hiện chuỗi method xảy ra ngoại lệ bị ngắt.
  Nếu thread ấy là thread main thì chết chương trình.
- Khối finally sẽ không được thực thi nếu chương trình bị thoát bằng cách gọi System.exit() hoặc xảy ra một lỗi (Error)
  không thể tránh khiến chương trình bị chết.
- Tất cả các khối catch phải được sắp xếp từ cụ thể nhất đến chung nhất (từ exception con đến exception cha)
- Tại một thời điểm chỉ xảy ra một ngoại lệ và tại một thời điểm chỉ có một khối catch được thực thi. Khi exception đã
  bị bắt ở một catch thì các catch tiếp theo sẽ không được bắt.

## Comparator and comparable

## JVM Architecture

- Class loader subsystem: là hệ thống tìm nạp class, verify các class và cấp phát bộ nhớ cho object variable để chạy app
- native method là phương thức được viết bởi ngôn ngữ khác như C++, Assembly... .Java xử dụng những method này để tương
  tác với OS và phần cứng
- Runtime data areas: là nơi JVM tổ chức lưu dữ liệu, byte code, đối tượng, tham số, ... trong thời gian chạy app
    - method area: là nơi chứa các metadata của class như là method, field, variables, được phân tích từ binary bởi JVM
      và
      vùng nhớ này cũng được chia sẻ giữa các thread
    - heap: là nơi lưu trữ các thể hiện của đối tượng(Objects)

## Thread

- `thread` là 1 sub-process, đơn vị nhỏ nhất của máy tính có thể thực hiện công việc riêng biệt
- `multi thread` là 1 process thực hiện nhiều luồng(thread) đồng thời
- `Multitasking`: là khả năng chạy đồng thời nhiều application cùng 1 lúc trong OS
- `Thread.State`: trạng thái của luồng
    - `NEW`: trạng thái vừa mới khởi tạo và chưa chạy
    - `RUNNABLE`: trạng thái khi đã gọi start()
    - `WAITING`: luồng chờ không giới hạn cho đến khi có 1 luồng gọi notify đến nó
    - `TIMED_WAITING`: chờ trong 1 time nhất định hoặc có 1 luống khác đánh thức nó
    - `BLOCKED`: là trạng thái `Not Runnable`, vẫn sống nhưng không được chọn để chạy, đang chờ unlock từ 1 luồng khác
    - `TERMINATED`: trạng thái kết thúc hoặc dead khi phương thức run đã bị thoát
- sự khác nhau giữa run() và start():
    - `run` sẽ được gọi như 1 phương thức trên 1 đối tượng bình thường và chạy trên luồng main dẫn đến không phải đa
      luồng
    - `start`: sẽ tạo ra 1 thread mới và cấp phát tài nguyên để chạy trên luồng đó
- sử dụng Runnable interface khi mà cần đa kế thừa và sử dụng Thread Pool cũng rất hiệu quả
- trong class `Thread`
    - suspend(): ngừng cấp CPU cho thread để thred ngừng hoạt động nhưng không có dừng ngay lập tức mà đợi trả CPU xong
      mới dừng
    - resume(): cấp lại CPU cho luồng đang dừng để luồng tiếp tục chạy
    - stop(): buộc kết thúc thread bằng cách ném ra 1 ngoại lệ, nếu như thread dừng đang nắm tài nguyên mà thread khác
      đang chờ thì sẽ bị deadlock
    - destroy(): dừng hẳn thread
    - join(): đợi tới khi thread này kết thúc thì thread cha mới được tiếp tục
    - join(long): thread cha phải đợi milliseconds kể từ lúc gọi join thì mới được tiếp tục
    - priority: mức độ ưu tiên của thread
    - interrupt(): làm gián đoạn thread trong java nếu nhưng thread đó đang trong trạng thái sleep hoặc wait, các thread
      bị gián đoạn sẽ ném ra 1 ngoại lệ InterruptedException, nếu các thread không trong trạng thái sleep hoặc wait thì
      không xảy ra chuyện gì nhưng đặt cờ interrupt thành true
    - xử lý ngoại lệ băng setUncaughtExceptionHandler()

### volatile && Atomic

- `Volatile`: Biến volatile được sử dụng để đảm bảo rằng các luồng (threads) khác nhau đều nhìn thấy phiên bản mới nhất
  của biến đó. Khi một biến được khai báo là volatile, việc đọc và ghi vào biến đó sẽ được đồng bộ hóa theo cách đảm bảo
  tính nhất quán và đúng đắn. Ngoài ra, biến volatile cũng không được chỉnh sửa bộ nhớ đệm (caching) và các thay đổi sẽ
  được lưu trực tiếp vào bộ nhớ chính. Tuy nhiên, biến volatile không đảm bảo tính toàn vẹn (atomicity) cho các phép
  toán không gian lặp (compound operations). Nếu ghi đè cùng lúc vẫn có thể bị lỗi không nhất quán

- `Atomic`: Biến Atomic là một tập hợp các lớp trong gói java.util.concurrent.atomic cung cấp các phương thức và lớp để
  thực
  hiện các hoạt động đồng bộ hóa an toàn trên các biến. Các lớp Atomic đảm bảo rằng các phép toán đọc/ghi trên biến được
  thực hiện một cách nguyên tử (atomic) và không bị gián đoạn bởi các luồng khác. Điều này đồng nghĩa với việc các hoạt
  động đọc/ghi sẽ luôn được hoàn thành mà không bị can thiệp. Các lớp Atomic cung cấp phương thức như get(), set(),
  compareAndSet(), incrementAndGet(), v.v.

=> Tóm lại, biến volatile đảm bảo tính nhất quán và đúng đắn khi đọc/ghi, trong khi biến Atomic đảm bảo tính toàn vẹn và
an
toàn trong các hoạt động đồng bộ hóa

## Sync and Async

`https://gpcoder.com/3514-dong-bo-hoa-cac-luong-trong-java/`

- `Java monitor`: là công cụ hỗ trợ giám sát trong việc đồng bộ các luồng
    - `acquiring the monitor`: trạng thái trước khi có monitor, sẽ được monitor bảo vể trước khi active
    - `owning the monitor`: trạng thái gianh được
    - `releasing the monitor`: trạng thái vừa mới thoát monitor
    - `exiting the monitor`: trạng thái thoát hẳn

- có 3 loại đồng bộ: synchronized methods, synchronized blocks, synchronized static methods
    - khối đồng bộ có ưu điểm hơn method là nó chỉ đồng bộ 1 phần, giảm khả năng trì hoãn
    - synchronized static methods lấy khóa là class chứa nó ([Object].class)

### synchronized block:

- khối đồng bộ synchronized được sử dụng để đảm bảo rằng chỉ một luồng có thể thực thi vào một thời điểm trên một đối
  tượng hoặc một phạm vi cụ thể. Khi một luồng thực thi vào một khối đồng bộ, nó sẽ sở hữu khóa (lock) của đối tượng
  hoặc phạm vi đó, và các luồng khác phải chờ đến khi khóa được giải phóng trước khi có thể thực thi vào khối đồng bộ
  đó.
- khóa của khối đồng bộ (synchronized block) sẽ được khóa (locked) khi một luồng thực thi vào khối đồng bộ đó và sẽ được
  giải phóng (unlocked) khi luồng đó thoát khỏi khối đồng bộ hoặc khi nó gặp một exception.
- Khi một luồng thực thi vào khối đồng bộ, nó sẽ yêu cầu khóa (lock) của đối tượng hoặc phạm vi mà khối đồng bộ áp dụng.
  Nếu khóa không được sở hữu bởi luồng khác, luồng hiện tại sẽ sở hữu khóa và được phép thực thi vào khối đồng bộ. Các
  luồng khác muốn thực thi vào cùng khối đồng bộ sẽ phải chờ cho đến khi khóa được giải phóng.
- method wait() của 1 lock sẽ giải phóng khóa đó tạm thời (lock.wait()) cho đến khi nhận được notify

### deadlock

- nếu 1 thread đang giữ 1 khóa và cố lấy 1 khóa mà thread khác đang giữ thì sẽ bị chờ và nếu không lấy được thì sẽ thành
  deadlock

### avoid

- không nên sử dụng Thread.stop(): Nếu một luồng bị dừng trong khi đang giữ monitor, monitor đó sẽ không bao giờ được
  giải phóng và có thể dẫn đến tình huống bị kẹt (deadlock) khi các luồng khác cố gắng chiếm monitor đó.

- không nên sử dụng Thread.suspend() và Thread.resume() vì dẫn đến việc các luồng đang cần dữ liệu mà luồng bị suspend
  khóa cũng bị
  dừng theo, nếu luồng đang chờ lại là luồng sẽ làm công việc resume() luồng đang khóa thì Deadlock sảy ra.
- không nên sử dụng Thread.destroy() vì nó giống như Thread.suspend() nhưng không thể cấp lại CPU để luông tiếp tục chạy
  được

### daemon thread

- có thể set daemon bằng method setDaemon(boolean)
- không thể setDaemon cho 1 non-DaemonThead đang chạy và ngược lại
- Daemon thread sẽ kết thúc khi luồng đang gọi nó kết thúc bất kể có đang làm gì

## Thread pool

- java Concurrency hỗ trợ vài loại thread pool sau:
    - `Cached thread pool`: giữ thread còn sống và tạo mới nếu cần
    - `Fixed thread pool`: giới hạn số lượng tối đa thread, các task chờ sẽ ở trong hàng đợi BlockingQueue
    - `Single-threaded pool`: chỉ giữ một thread thực thi một nhiệm vụ một lúc.
    - `Fork/Join pool`: một Thread đặc biệt sử dụng Fork/ Join Framework để tận dụng lợi thế của nhiều bộ vi xử lý để
      thực
      hiện công việc lớn nhanh hơn bằng cách chia nhỏ công việc thành các phần nhỏ hơn để xử lý đệ quy.

### Executor

- là đối tượng quản lý các luồng và thực hiện các tác vụ Runnable được yêu cầu xử lý. tách riêng các chi tiết của việc
  tạo Thread, lập kế hoạch (scheduling), … để chúng ta có thể tập trung phát triển logic của tác vụ mà không quan tâm
  đến các chi tiết quản lý Thread.
- các interface cơ bản:
    - `Executor`: là interface cha của tất cả của Executor
    - `ExecutorService`: là một Executor cho phép theo dõi tiến trình của các tác vụ trả về giá trị (Callable) thông qua
      đối
      tượng Future, và quản lý việc kết thúc các luồng. Các phương thức chính của nó bao gồm submit() và shutdown().
    - `ScheduledExecutorService`: là một ExecutorService có thể lên lịch cho các tác vụ để thực thi sau một khoảng thời
      gian
      nhất định, hoặc để thực hiện định kỳ. Các phương thức chính của nó là schedule(), scheduleAtFixedRate() and
      scheduleWithFixedDelay().
- tạo executor bằng class util `Executors`:
    - newSingleThreadExecutor(): chỉ có 1 thread trong thread pool và các task xử lý tuần tự
    - newCachedThreadPool(): có nhiều thread trong thread pool, thread sẽ được tái sử dụng, thread sẽ tắt nếu trong 60s
      không sử dụng
    - newFixedThreadPool(): tạo ra số thread cố định trong thread pool, các task chờ sẽ đẩy vào Blocking Queue
    - newScheduledThreadPool(): tương tự newCachedThreadPool() nhưng có thời gian delay giữa các thread
    - newSingleThreadScheduledExecutor(): tương tự như newSingleThreadExecutor nhưng có thời gian delay giữa các thread
- method shutdown() sẽ từ chối nhận task và sẽ đợi các task đang hoàn thành chạy xong mới shutdown

### callable & future

- khi submit vào 1 future thì sẽ trả về 1 đối tượng Future
- khi gọi method get() của future thì nó sẽ lấy kết quả trả về của task, nếu không có thì nó sẽ block main thread và đợi
  kết quả
- có thể hủy task bằng method cancelled() và sau khi gọi cancel thì isDone luôn là true
- Một Future được sử dụng như là một tham chiếu đến kết quả của một tác vụ bất đồng bộ

### completableFuture

- có thể xử lý chuỗi, xử lý exception
- implement từ CompletionStage, CompletionStage là 1 promise, cung cấp call back để xử lý bất đồng bộ mà không cần phải
  block thread

### get() && join()

- CompletableFuture: join không ném ra ngoại lệ vì nó kết hợp ngoại lệ vào kết quả thực thi và có thể kêt hợp trong
  chuỗi CompletableFuture để tổng hợp kết quả, get thì ném ra ngoại lệ lúc thực thì và phải xử lý
- ForkJoinPool: join có thể được gọi từ 1 task khác trong cùng 1 pool còn get thì không còn lại giống CompletableFuture

## Fork/ Join

- cung cấp các công cụ giúp tăng tốc xử lý song song bằng cách cố gắng sử dụng tất cả các lõi bộ xử lý có sẵn, được thực
  hiện thông qua cách tiếp cận phân chia (fork) và gộp (join) task
- tương tự như ExecutorService nhưng có 1 chút khác biệt như:
    - phân chia các task cho các thread thức thi trong thread pool
    - sử dụng thuật toán work stealing

### ForkJoinPool

- là 1 thread pool đặc biệt sử dụng fork/join framework
- 1 số class trong framework
    - ForkJoinTask<V>: đại diện cho task được thực thi trong fork/join pool

### submit() && invoke() && execute()

- execute(): chạy bất đồng bộ và đầu vào là runnable
- submit(): tương tự execute() nhưng đầu vào là callable
- invoke(): chạy đồng bộ và đầu vào là callable( luông block thread để chờ kết quả )

## Semaphore

- là bộ quản ký ticket, có thể kết hợp với thread để quản lý luồng
- `acquire()`: sẽ lấy ra 1 ticket
- `release()`: trả lại 1 ticket
- `availablePermits()`: kiểm tra số lượng ticket có sẵn
- Nếu ticket không có sẵn, acquire() sẽ bị lock cho đến khi có ticket
- Mutex là Semaphore với bộ đếm là 1, tức là 1 thời điểm chỉ có 1 permit được thực hiện
