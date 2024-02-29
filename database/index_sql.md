- đơn vị lưu trữ nhỏ nhất của database là page hoặc block
- leaf node: là 1 node bao gồm 1 hoặc nhiều cục index


- index sử dụng double linkedList để lưu index
- sử dụng B-tree(Balanced search tree) để tìm kiếm vị trí index
- nếu truy vấn bằng primary key thì sẽ luôn nhanh bởi chỉ có 1 bản ghi duy nhất, tránh được duyệt qua các leaf node
- truy vấn bằng index sẽ thông qua các bước:
    - Duyệt cây
    - Duyệt theo các leaf node
    - Lấy dữ liệu trong bảng
- index sẽ được tìm như 1 quyển danh bạ vậy, chũ cái đầu tiên trước, nếu đánh index kết hợp thì nên ưu tiên trường cần
  truy vấn hoặc trường hay truy vấn lên trước.
- nếu truy vấn có theo param chứ không phải value thì cần phải có statistics hợp lý để database tạo plan hợp lý cho mỗi table
- mỗi lần update index thì `nên` update lại statistics của index lẫn table
- có thể dùng function-user-defined để đánh index nhưng kết quả của func đó phải là bất biến
- việc sử dụng param trong câu query sẽ làm cho database không đánh giá được câu đó nên chọn execution plan nào và có
  thể gây chậm nhưng nó lại có 1 mẫu execute plan chung(cost trung bình) với param khác nhau
- khi query thì db sẽ có 1 `Column histogram` để tính toán số lượng bản ghi ước tính -> hữu ích với sử dụng param nhưng
  chậm

- đánh index để ý để giá trị bằng trước rồi sau đó đến range
- trong câu tìm like thì nên để wildcard % ở sau, càng lùi về sau càng dễ ăn index, ngược lại thì dễ dính fullText index
- nên để 1 index nhiều trường hơn là 1 trường 1 index, nếu có nhiều index trên 1 câu query thì nó sẽ access cả 2 rồi map
  lại, có 2 cách map:
    - join kết quả
    - bitmap index: tùy loại db dùng hay không nhưng rất tốn hiệu năng
- một số db cung cấp 1 tiện ích gọi là partial(postgre), filtered(SQL server) dùng để thêm câu điều kiện vào câu
  index -> truy vấn nhanh hơn
- oracle có định nghĩa empty string là null và ngược lại
- nếu tạo 1 index có 1 trường là null và có 1 trường là not null(hoặc constant) thì khi query trường is null sẽ luôn
  được ăn index
- có thể dùng internal function của oracle để làm điều kiện not null cho index is null
- hạn chế sử dụng hàm ở bên trái dấu `=` và dùng (between, <, >, <=, >=) cho kiểu date, datetime, nên sử dụng điều kiện
  chính xác (<,>), vẫn có thể sử dụng hàm bên phải dấu `=`
- khi sử dụng like thì db ngầm định convert về varchar để so sánh nên có thể sẽ không ăn index 1 số trường hợp
- nếu so sánh kiểu number và kiểu string trong điều kiện where thì db sẽ ngầm định convert từ string sang number
- Access predicates: là điều kiện bắt đầu hoặc kết thúc việc tìm kiếm theo index. Nó xác định phạm vi index được quét.