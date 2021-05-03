# REST API

You can test it vai Postman!

## Setup local

**Note:** required node version > 10.

- npm install
- npm run dev

## Setup with docker

- docker build . -t api-server
- docker run --rm -d  -p 8080:8080/tcp api-server:latest

## Example of request method

Use JSON format in form-data

*GET*: **localhost:8080**

```json
{
    "id": 0
}
```

*POST*: **localhost:8080/post**

```json
{
    "id": 0,
    "name": "Anna",
    "age": 15
}
```

*POST*: **localhost:8080/update**

```json
{
    "name": "Igor",
    "age": 22
}
```

*DELETE*: **localhost:8080**

```json
{
    "id": 0
}
```
