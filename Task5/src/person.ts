export default class Person {
    private _name: string;
    private _age: number;
    private readonly _id: number;

    constructor(name: string, age: number, id: number) {
        this._name = name;
        this._age = age;
        this._id = id;
    }

    get getPersonInfo() {
        return { name: this._name, age: this._age }
    }

    get id() {
        return this._id;
    }

    set name(newName: string) {
        this._name = newName;
    }

    set age(newAge: number) {
        if (newAge < 0) {
            throw new Error("Weird, man, weird....")
        }

        this._age = newAge;
    }
}