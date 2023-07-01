

Khi cpu đọc dữ liệu nó sẽ đọc 1 khối bộ nhớ 1 lúc, lưu vào memory cache, 
khi nó truy nạp dữ liệu nó sẽ xem dữ liệu cần có đang nằm trong cache ko?, 
nếu có lấy luôn ( nên tốc độ nhanh ), ko có thì nó lại phải đọc 1 khối dữ liệu khác vào cache rồi dùng. 
Đối với mảng, khi truy xuất theo dòng thì các phần tử mảng sẽ nằm theo thứ tự, mỗi lần đọc dữ liệu, 
cpu đọc cả 1 khối dữ liệu vào, nó sẽ gồm nhiều phần tử mảng vào cache, do đó tốc độ nhanh, 
còn truy xuất theo cột thì sau khi đọc 1 khối bộ nhớ vào cache, xài đc 1 phần tử, rồi lại đọc 1 khối bộ nhớ vào cache, 
xài đc 1 phần tử.... nên nó lâu.