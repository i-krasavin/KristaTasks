import express from "express";
import cors from "cors";
import PersonList from "./src/personList";

const list = new PersonList();
list.addPerson("Test person", 10);

const app = express();
const port = 8080; // default port to listen
app.use(cors());
app.use(express.json());
// okay, the GOD class isn't best practice, but for review of REST logic is normal
// Will business logic hang out with friends? )))

app.get("/", (req, res) => {
    const { id } = req.body;
    const result = list.getPerson(id);
    res.send({ ...result });
});

app.post("/post", (req, res) => {
    const { name, age } = req.body;
    list.addPerson(name, age);
    res.send("Success, but I'm not sure, I don't have any try catch and middleware oops...");
});

app.post("/update", (req, res) => {
    // okay, we can trust all users and of course they don't send us something dangerous ))) no sql injection
    const { id, name, age } = req.body;
    list.updatePerson(id, name, age);
    const result = list.getPerson(id);
    res.send({ ...result });
});

app.delete("/", (req, res) => {
    const { id } = req.body;
    const result = list.deletePerson(id);
    res.send("Success, but I'm not sure, I don't have any try catch and middleware oops...");
});


// start the Express server
app.listen(port, () => {
    console.log(`server started at http://localhost:${port}`);
});