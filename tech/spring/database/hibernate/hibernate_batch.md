## CONCEPT

- là khả năng xử lý nhiều bản ghi cùng 1 lúc của hibernate

## EXAMPLE

- khi lưu 1 loạt dữ liệu thì hibernate sẽ lưu vào L1 cache trước
- `IDENTITY generator` sẽ disable Hibernate sử dụng JDBC batch insert. JDBC batch updates và delete sẽ không bị ảnh hưởng
  bởi `IDENTITY generator`.
- với `SEQUENCE` thì nó hibernate sẽ luôn gọi nextval() để có được giá trị tiếp theo của entity còn IDENTITY thì nó sẽ
  không có method này của database
- Chúng ta sẽ sử dụng các phương thức `flush() và clear()` của đối tượng Session để Hibernate tiếp tục bản ghi này vào cơ
  sở dữ liệu thay vì lưu trữ chúng trong bộ nhớ cache. Tránh lỗi `OutOfMemoryException`
- `StatelessSession` sẽ không cache lại ở bất cứ mức nào: first-level cache, second-level hay query cache. Nó cũng không
  gắn với một `Persistence Context` nào. Vì vậy sử dụng cách này sẽ không sợ cache làm OutOfMemory.