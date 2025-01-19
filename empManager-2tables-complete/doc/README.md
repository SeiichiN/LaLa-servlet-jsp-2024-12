# empManager-2tables

## ねらい

1. サーブレットとJSPを整理する。
1. テーブルを2つにして、結合する。
1. 年齢は誕生日から計算する。

## サーブレットとJSPを整理する

### 現状

#### 新規登録

:CreateServlet         --> createEmp.jsp --> 
:CreateConfirmServlet --> createConfirm.jsp --> 
:CreateDoneServlet    --> createDone.jsp

#### 更新処理

:UpdateServlet        --> updateEmp.jsp -->
:UpdateConfirmServlet --> updateConfirm.jsp -->
:UpdateDoneServlet    --> updateDone.jsp

#### 削除処理

:RemoveConfirmServlet --> removeCofirmEmp.jsp -->
:RemoveDoneServlet    --> removeDone.jsp

#### 変更

:InputServlet --> input.jsp  -->
:ConfirmServlet --> confirm.jsp -->
:DoneServlet --> done.jsp

#### URLパターン

:InputServlet -- "/createInput","/updateInput","/removeInput"

:ConfirmServlet -- "/createConfirm", "/updateConfirm"

:DoneServlet -- "/createDone", "/updateDone", "/removeDone"

<!-- 修正時刻: Mon 2025/01/13 10:47:48 -->
