# SpringBoot Demo

## Start
```bash
# start server
./run.sh  
```

## 接口
- GET http://localhost:9900/greeting
  - query 参数: name=string
  - response JSON: { id: 自增id,  "content": "Hello, ${name}!" }
- POST http://localhost:9900/greeting
  - 参数 application/json，{ id: '',  "content": "kevin" }
  - response JSON: { id: 自增id,  "content": "Hello, ${content}!" }

允许跨域、前端请求
```html
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
  axios.post('http://localhost:9900/greeting', {
    "id": 1,
    "content": "测试"
  }).then((res) => {
    console.log('请求成功，', res)
  }, (err) => {
    console.log('请求发生了错误,', err)
  })
</script>
```