import Person from "./person";

export default class PersonList {
    private listOfPeople = new Map<number, Person>();


    public addPerson(name: string, age: number) {
        const uuid = this.listOfPeople.size; // cool joke, bro
        this.listOfPeople.set(uuid, new Person(name, age, uuid));
    }

    public getPerson(personalId: number) {
        return this.listOfPeople.get(personalId).getPersonInfo;
    }

    public updatePerson(personalId: number, newName?: string, newAge?: number) {
        if (!!newName) {
            this.listOfPeople.get(personalId).name = newName;
        }

        if (!!newAge) {
            this.listOfPeople.get(personalId).age = newAge;
        }
    };

    public deletePerson(personalId: number) {
        this.listOfPeople.delete(personalId);
    }

}