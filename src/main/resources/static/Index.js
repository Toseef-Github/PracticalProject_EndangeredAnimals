'use strict';

// const output = document.getElementById('output');

document.getElementById('animalsForm').addEventListener("submit", function (event) {
    event.preventDefault();

    const form = event.target;

    const animal = {
        name: form.name.value,
        animalGroup: form.animalGroup.value,
        population: form.population.value,
        diet: form.diet.value,
        lifespan: form.lifespan.value,
    }

    axios.post("http://localhost:8080/createAnimal", animal)
        .then(res => {
            console.log("RESPONSE: ", res);
            form.name.focus();
            form.reset();
            console.log("success");
            renderAnimals();
        })
        .catch(err => console.error(err));

    console.log("animal: ", animal);
});

const output = document.getElementById('output');

function renderAnimals() {
    axios.get("http://localhost:8080/getAnimals")
        .then(res => {
            console.log("animals: ", res.data);
            output.innerHTML = "";
            for (let animal of res.data) {
                const animalCol = document.createElement("div");
                animalCol.className = "col-4";

                const animalCard = document.createElement("div");
                animalCard.className = "card";
                animalCol.appendChild(animalCard);

                const animalDiv = document.createElement("div");
                animalDiv.className = "card-body";
                animalCard.appendChild(animalDiv);

                const animalName = document.createElement("h2");
                animalName.innerText = animal.name;
                animalDiv.appendChild(animalName);

                const animalPopulation = document.createElement("p");
                animalPopulation.innerText = "Current Population = " + animal.population;
                animalDiv.appendChild(animalPopulation);

                const animalLifespan = document.createElement("p");
                animalLifespan.innerText = "Average Lifespan = " + animal.lifespan + " Years";
                animalDiv.appendChild(animalLifespan);

                const animalGroup = document.createElement("p");
                animalGroup.innerText = "Group = " + animal.animalGroup;
                animalDiv.appendChild(animalGroup);

                const animalDiet = document.createElement("p");
                animalDiet.innerText = "Diet = " + animal.diet;
                animalDiv.appendChild(animalDiet);

                const animalUpdate = document.createElement('button');
                animalUpdate.innerText = "Update";
                animalUpdate.classList.add("btn", "btn-secondary");
                animalUpdate.addEventListener("click", () => {
                    if (confirm('Are you sure?')) {
                        txt = console.log(updateAnimal(animal.id));
                    } else {
                    txt = "You pressed cancel";
                    }
                });
                
                
                
                // addEventListener("click", () => {
                //     console.log();
                //     updateAnimal(animal.id);
                // });

                animalDiv.appendChild(animalUpdate);

                output.appendChild(animalCol);

                const animalDelete = document.createElement("button");
                animalDelete.innerText = "Delete";
                animalDelete.classList.add("btn", "btn-danger");
                animalDelete.addEventListener("click", () => {

                    if (confirm('Are you sure?')) {
                        txt = console.log(deleteAnimal(animal.id));
                    } else {
                    txt = "You pressed cancel";
                    }
                });

                animalDiv.appendChild(animalDelete);

                output.appendChild(animalCol);
            }
        })
        .catch(err => console.error(err));
}

function updateAnimal(id) {
    const updateName = document.getElementById("name").value
    const updatePopulation = document.getElementById("population").value
    const updateLifespan = document.getElementById("lifespan").value
    const updateAnimalGroup = document.getElementById("animalGroup").value
    const updateDiet = document.getElementById("diet").value
    
    axios.patch(`http://localhost:8080/updateAnimal/${id}?name=${updateName}&population=${updatePopulation}&lifespan=${updateLifespan}&animalGroup=${updateAnimalGroup}&diet=${updateDiet}`)
    
            .then(res => {
                console.log("RESPONSE: ", res);
                renderAnimals();
            }).catch(err => console.error(err));
        }


function deleteAnimal(id) {
    axios.delete("http://localhost:8080/removeAnimal/" + id)
        .then(res => {
            console.log(res);
            renderAnimals();
        })
        .catch(err => console.error(err));
}


renderAnimals();