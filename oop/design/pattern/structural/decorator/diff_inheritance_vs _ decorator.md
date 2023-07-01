- Khi sử dụng Decorator, bạn có thể tạo nhiều đối tượng decorator khác nhau để mở rộng chức năng của một đối tượng gốc.
  Ví dụ, nếu bạn có một đối tượng Coffee gốc, bạn có thể tạo ra nhiều đối tượng decorator khác nhau để thêm các chức
  năng khác nhau vào đối tượng Coffee gốc đó, chẳng hạn như thêm sữa, đường, kem, v.v.

- Mỗi decorator sẽ giữ một tham chiếu đến đối tượng Coffee gốc, và khi bạn gọi phương thức trên đối tượng decorator, nó
  sẽ gọi phương thức tương ứng trên đối tượng Coffee gốc và thêm các chức năng của decorator vào kết quả trả về.

- Ví dụ, nếu bạn có một đối tượng Coffee gốc và tạo ra hai đối tượng decorator MilkDecorator và WhipDecorator, `bạn có
  thể sử dụng cả hai đối tượng decorator này để mở rộng chức năng của đối tượng Coffee gốc đó`. Khi bạn gọi phương thức
  trên đối tượng WhipDecorator, nó sẽ gọi phương thức trên đối tượng MilkDecorator và sau đó gọi phương thức trên đối
  tượng Coffee gốc để tính toán kết quả cuối cùng.

- Trong khi đó, khi sử dụng kế thừa, bạn chỉ có thể tạo ra một lớp con mới mở rộng một lớp cha duy
  nhất. `Nếu bạn muốn thêm các chức năng khác nhau vào lớp cha, bạn phải tạo ra các lớp con mới khác nhau cho mỗi chức năng đó`,
  và đây có thể làm cho cấu trúc của lớp con trở nên phức tạp và khó bảo trì.