## CONCEPT

- Là một hệ thống tìm kiếm và phân tích dữ liệu phân tán mã nguồn mở. Nó sử dụng mô hình chỉ mục ngược (inverted index)
  để tạo ra các chỉ mục tìm kiếm


- cluster: là 1 tập hợp các node
- node: là 1 instance của ES
- index: tựa như table của sql, nơi chứa các document liên quan tới nhau
- field: tựa như column trong sql
- document: tựa như rows trong sql
- mapping: là quá trình xử lý cách mà các DOCUMENT (và các PROPERTIES bên trong) sẽ được index và lưu trữ như thế nào.
  MAPPING giúp chúng ta cùng lúc khởi tạo 1 field & định nghĩa cách field đó được index
- Analysis là quá trình mà Elasticsearch sử dụng để phân tích văn bản đầu vào thành các thành phần nhỏ hơn
- `Query DSL`: bộ truy vấn bằng json của ES

#### Analyzer

- là quy tắc mà es dùng trong quá tringh analysis cho 1 field nhất định
- Analyzer là tổ hợp giữa tokenizer và các token filters.
    - `Tokenizers` được sử dụng để tách văn bản thành các đơn vị nhỏ hơn, gọi là tokens. Ví dụ, tokenizer có thể tách
      văn
      bản thành các từ riêng lẻ hoặc thành các chuỗi ký tự theo quy tắc nhất định.
    - `Token filters` được áp dụng để tiến hành các thay đổi và xử lý trên các tokens này. Các token filters có thể thực
      hiện các nhiệm vụ như loại bỏ stop words, chuẩn hóa chữ hoa/thường, loại bỏ dấu câu, chuyển đổi từ đồng nghĩa, và
      nhiều tác vụ xử lý văn bản khác.

#### `Shard` trong Elasticsearch

- có thể hình dung giống với block(page) của SQL
- là một đơn vị lưu nhỏ của dữ liệu được chia thành các mảnh để phân tán lưu trữ trên nhiều node.
- Mỗi shard chứa một phần của chỉ mục ngược (inverted index) và tài liệu dữ liệu
- Có 2 lọa shard:
    - Primary shard: shard chính và được tạo ra khi tạo index, không thể thay đổi
    - Replica shard: bản sao chép của primary shard

#### `Chỉ mục ngược (inverted index)`

- có thể hình dung giống với index trong SQL
- là một phần quan trọng của Elasticsearch và chứa thông tin về từ khóa và vị trí của các document trong shard.
- Chỉ mục ngược được tạo ra từ dữ liệu thực tế của các document và được lưu trữ cùng với dữ liệu trên cùng một shard.

## Rule for query

- Thiết kế schema: Xác định các trường và loại dữ liệu một cách chính xác. Lựa chọn các loại trường phù hợp như text,
  keyword, number, date, và boolean.

- Phân tích dữ liệu: Sử dụng phân tích văn bản và phân tích từ khoá để xử lý dữ liệu đầu vào trước khi lưu trữ. Điều này
  giúp tìm kiếm và lọc dữ liệu hiệu quả hơn.

- Quản lý cấu hình: Điều chỉnh các thiết lập như số lượng shard và replica, cấu hình index và global search settings để
  phù hợp với yêu cầu và tải của hệ thống.

- Tối ưu hóa truy vấn: Sử dụng các tính năng như query caching, filter caching, và query rewriting để tăng tốc độ truy
  vấn. Sử dụng các loại truy vấn phù hợp như term, match, range, và bool để tìm kiếm dữ liệu một cách hiệu quả.