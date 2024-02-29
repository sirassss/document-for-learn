### SOME CONCEPT

> Khi bạn sử dụng các lệnh Git để xem thông tin về các commit, Git sẽ tự động hiển thị mã hash đầy đủ 40 ký tự của các
> commit. Tuy nhiên, bạn có thể sử dụng tùy chọn -abbrev=<n> để yêu cầu hiển thị mã hash được rút gọn với số ký tự là n.
> Ví dụ, nếu bạn muốn hiển thị mã hash rút gọn với độ dài là 7 ký tự, bạn có thể sử dụng lệnh git log --abbrev=7.
> Tóm lại, trong Git, mã hash của một commit có độ dài là 40 ký tự, tuy nhiên Git cung cấp tính năng "abbreviated hash"
> cho phép bạn sử dụng một số ký tự đầu tiên của mã hash để đại diện cho commit mà không cần phải sử dụng toàn bộ mã
> hash.
> Khi hiển thị thông tin về các commit, Git sẽ tự động hiển thị mã hash đầy đủ 40 ký tự của các commit, tuy nhiên bạn có
> thể sử dụng tùy chọn -abbrev=<n> để yêu cầu hiển thị mã hash được rút gọn với số ký tự là n.

### GIT REBASE

- `git rebase -i <commit>` là một lệnh trong Git cho phép bạn tái cấu trúc lịch sử commit trên một branch bằng cách gộp
  các commit lại với nhau, thay đổi thứ tự các commit, hoặc sửa đổi nội dung của các commit.

- Các tùy chọn phổ biến khi sử dụng git rebase -i bao gồm:
    + pick: để giữ nguyên commit và không thay đổi gì.
    + reword: để sửa đổi nội dung của commit.
    + edit: để dừng quá trình rebase tại commit đó để bạn có thể thực hiện các thay đổi khác trên lịch sử commit.
    + squash: để gộp commit hiện tại với commit trước đó.
    + fixup: để gộp commit hiện tại với commit trước đó mà không giữ lại thông tin commit message của commit hiện tại.

### GIT OTHER

> Cụ thể, git ls-remote sẽ hiển thị danh sách các tham chiếu của các remote branch và tag trên remote repository mà bạn đã
> liên kết với repository local của mình. Kết quả trả về của lệnh này sẽ bao gồm hai cột: cột đầu tiên là mã băm (hash)
> của đối tượng tương ứng với tham chiếu đó trên remote repository, và cột thứ hai là tên của tham chiếu đó (bao gồm cả
> tên branch và tag).
> Trong khi đó, git show-ref --heads <remote> sẽ chỉ hiển thị danh sách các tham chiếu của các remote branch trên remote
> repository mà bạn đã liên kết với repository local của mình. Kết quả trả về của lệnh này sẽ chỉ bao gồm tên của các tham
> chiếu của các remote branch, không bao gồm các tham chiếu của các tag hoặc các tham chiếu khác.
> Tóm lại, git ls-remote và git show-ref --heads <remote> đều được sử dụng để hiển thị danh sách các tham chiếu của các
> remote branch trên remote repository mà bạn đã liên kết với repository local của mình. Tuy nhiên, git ls-remote sẽ hiển
> thị danh sách các tham chiếu của cả remote branch và tag, trong khi git show-ref --heads <remote> chỉ hiển thị danh sách
> các tham chiếu của các remote branch.

### GIT IGNORE

- `git rm -r --cached .` dùng để xóa cached đã thêm vô git


- `git remote`: liệt kế các danh sách remote repositories ex: origin
- `git ls-remote [remote_name]`: danh sách các tham chiếu đên remote, mỗi 1 tham chiếu tương ứng với 1 branch, tag
- `git show-ref [remote_name]`: danh sách các tham chiếu đên remote, mỗi 1 tham chiếu tương ứng với 1 branch
- `git fetch`: lấy code từ remote về nhưng chỉ update cho các đối tựng tham chiếu ex: origin
- `git merge --continue`: khi fix conflict xong thì nên dùng để không phải tạo thêm 1 commit nữa
- `git log -n [number]`: danh sách lịch sử commit với <number> gần nhất
- `git rebase`: merge branch khác vào branch hiện tại mà không cần phải commit như git merge, thay đổi cả lịch sử commit
- `git stash [-u]`: gom code vào 1 commit ảo và stored vào 1 stack, option -u để thêm các untracked files
  - `git stash list`: lấy ra tất cả các commit ảo trong stack
  - `git stash apply [stash_id]`: lấy commit trong stack ra
  - `git stash pop [stash_id]`: lấy ra và xóa trong stack
  - `git stash drop [stash_id]`: xóa commit ảo mới nhất
  - `git stash clear`: xóa toàn bộ commit ảo trong stack
- `git commit --amend`: sửa đổi commit local gần nhất chứ không tạo commit mới
- `git reset --hard`: mặc định sẽ clear working directory và staging area và sẽ đưa HEAD về commit gần nhất
  - `git reset --hard [hash_commit]`: xóa sạch từ commit đó cho đến commit gần nhất
  - `git reset --mixed [hash_commit]`: xóa các commit sau nó và đưa các thay đổi của commit chỉ định vào working
    directory
  - `git reset --soft [hash_commmit]`: chuyển đến commit được chỉ định và các commit sau nó sẽ đưa vào staging area
- `git cherry-pick [hash_commit]`: lấy commit được chỉ định trong cả repository để lắp vào nhánh hiện tại
- `git push`:
  - `git push -u`: có thể thay là --up-stream, tác dụng là set up stream cho branch và sau đó không phải chỉ định
    remote cho mỗi command nữa
- `git branch` --set-upstream-to=origin/<remote-branch> <local-branch>: set upstream cho branch