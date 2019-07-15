# kanboard-task-read-write
KanboardタスクReaderとWriterを実装しています。

タスクReaderとWirterを実装する上で、JavaでAPIの実装をおこなっています。

## 設定

Kanbordのconfig.phpで以下の設定変更をおこなってください。

変更前
> define('API_AUTHENTICATION_HEADER', '');

変更後
> define('API_AUTHENTICATION_HEADER', 'X-API-Auth');

以下のOSのシステム環境変数を設定してください。

|環境変数名|設定値|
|:---------|------|
