## CONCEPT

- `Realm`: là 1 vùng quản lý các client
- `Client`: là các application, resource server
- `User`: là người dùng
- `Realm role`: là role cho cả realm, tất cả các client đểu kế thừa role này của realm
- `Client scopes`: là scope cho cả Realm

#### Client

###### Trường hợp là resource server thì có các khái niệm sau:

- `ROLE`: là quyền mà client có 
- `Client scopes`: là scope mà client có, dùng để định nghĩa các thuộc tính của user(hoặc default của keycloak) có thể thêm vào token với mapper
- `Authorization`: là cách phân quyền truy cập tài nguyên, api mà client định nghĩa
  - `Policy enforcement mode`: các mode để check authorization
    - `Enforcing`: nếu không có định nghĩa resource thì sẽ không có quyền truy cập
    - `Permissive`: nếu có đinh nghĩa resource thì sẽ không có quyền truy cập
    - `Disabled`: tắt tính năng phân quyền
  - `Decision strategy`: là chiến lược để phân quyền
    - `Unanimous`: tất cả là Positive thì được truy cập
    - `Affirmative`: có ít nhất 1 Positive thì được truy cập
  - `Resources`: định nghĩa restful api cho client
  - `Scopes`: phạm vi của resource, có thể coi là 1 resource group
  - `Policies`: các chính sách user truy cập vào resource của client
  - `Permission`: là cách phân quyền của client mà user phải tuân theo
    - bao gồm 2 kiểu là resource và scope
- `Service accounts roles`: là các role mà các client có 
  - `uma_protection`: là role cho phép 1 client có thể lấy resource, scope, policy từ keycloak server để check quyền của user