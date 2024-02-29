## concept

- Đại diện cho 1 đơn vị làm việc với DB

- `Atomicity`: tất cả các hoạt động của transaction hoặc là thực thi thành công hết hoặc là không có bất cứ hành động
  nào được thực khi có bất kỳ một hoạt động thực thi không thành công.
    - Abort: tất cả không được đồng bộ xuống db
    - Commit: đồng bộ hết
- `Consistency`: tất cả các ràng buộc toàn vẹn dữ liệu(constraints, key, data types, Trigger, Check) phải được thực thi
  thành công cho mọi transaction phát sinh xuống database, nhầm đảm bảo tính đúng đắn của dữ liệu.
- `Isolation`: đảm bảo các transaction xảy ra xen kẽ sẽ không làm ảnh hưởng đến tính nhất quán của dữ liệu. Các thay đổi
  dữ liệu bên trong mỗi transaction sẽ được cô lập, các transaction khác sẽ không thể nhìn thấy cho đến khi nó được đồng
  bộ xuống database.
- `Durability`: đảm bảo một transaction thực thi thành công thì tất cả những thay đổi trong transaction phải được đồng
  bộ xuống database bất kể cả khi hệ thống xảy ra lỗi hoặc bị mất điện. Các transaction thành công nhưng chưa được đồng
  bộ xuống database phải được đồng bộ lại khi hệ thống hoạt động trở lại.


- Đảm bảo tính toàn vẹn của phiên làm việc với DB
- Có 2 cơ chế lock:
    - row-level locking
    - table-level locking
- Thuộc tính `isolation` được sử dụng để cấu hình mức độ cô lập của các transaction. Mức độ cô lập quy định cách mà các
  transaction truy cập vào dữ liệu trong cơ sở dữ liệu và đảm bảo tính nhất quán của dữ liệu trong các transaction.
  Có 4 mức độ cô lập được hỗ trợ trong Spring:
    - `DEFAULT`: Cơ sở dữ liệu sử dụng mức độ cô lập mặc định.
    - `READ_UNCOMMITTED`: Transaction có thể đọc các thay đổi chưa được commit của các transaction khác.
    - `READ_COMMITTED`: Transaction chỉ đọc các thay đổi đã được commit của các transaction khác.
    - `REPEATABLE_READ`: Transaction đọc các thay đổi đã được commit của các transaction khác và đảm bảo rằng các thay
      đổi này không thay đổi trong quá trình thực hiện transaction hiện tại.
    - `SERIALIZABLE`: Các transaction được thực hiện một cách tuần tự và tách biệt nhau, đảm bảo tính nhất quán của dữ
      liệu.
- Thuộc tính `propagation` được sử dụng để cấu hình phạm vi của transaction. Có 7 phạm vi được hỗ trợ trong Spring:
    - `REQUIRED`: Nếu một transaction đã tồn tại, thì các thao tác trên cơ sở dữ liệu sẽ được thực hiện chung trong
      transaction đó, nếu không, một transaction mới sẽ được tạo.
    - `REQUIRES_NEW`: Luôn tạo mới một transaction mới, bất kể có transaction nào đang tồn tại.
    - `MANDATORY`: Yêu cầu rằng một transaction đã tồn tại, nếu không sẽ ném ra exception.
    - `NESTED`: Tạo ra một transaction lồng nhau trong transaction hiện tại.
    - `SUPPORTS`: Nếu một transaction đã tồn tại, thì các thao tác trên cơ sở dữ liệu sẽ được thực hiện trong
      transaction đó, nếu không, các thao tác sẽ không được thực hiện trong một transaction nào cả.
    - `NOT_SUPPORTED`: Các thao tác trên cơ sở dữ liệu sẽ không được thực hiện trong một transaction nào cả.
    - `NEVER`: Yêu cầu rằng không có transaction nào được phép tồn tại, nếu có sẽ gây ra lỗi.

## pessimistic lock

- cung cấp cơ chế khoá dữ liệu, đảm bảo không có transaction nào khác có thể sửa đổi hoặc xoá dữ liệu mà transaction
  hiện tại đang chiếm giữ, nó còn được gọi là exclusive lock.
- có 2 loại khóa như sau:
    - `shared lock` – Chỉ có thể đọc nhưng không thể xoá, cập nhật dữ liệu.
    - `exclusive lock` – Có thể xoá hoặc cập nhật dữ liệu .

- JPA định nghĩa 3 kiểu Lock sau:
    - `PESSIMISTIC_READ` – cho chúng ta một chìa khoá gọi là shared lock, chỉ có thể đọc.
    - `PESSIMISTIC_WRITE` – nhận một chìa khoá gọi là exclusive lock, có toàn quyền đọc, xoá, chỉnh sửa và ngăn không
      cho các transaction khác đọc, xoá, và cập nhật dữ liệu lên chúng
    - `PESSIMISTIC_FORCE_INCREMENT` – giống với cơ chế hoạt động của PESSIMISTIC_WRITE, ngoài ra nó còn tăng giá trị của
      thuộc tính version trong entity. 