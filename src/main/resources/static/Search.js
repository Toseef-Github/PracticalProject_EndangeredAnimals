document.getElementById('animalsSearch').addEventListener("submit", function (event) {
    event.preventDefault();

    const form = event.target;

    axios.get(`http://localhost:8080/getAnimalByName/${form.searchName.value}`)
        .then(res => {
            console.log("RESPONSE: ", res);
            form.searchName.focus();
            form.reset();
            console.log("success");
            var existingSearchDiv = document.getElementById('searchAnimalsDiv');
            if (existingSearchDiv != null) {
                existingSearchDiv.remove();
            }
            for (let animal of res.data) {
                const animalCol = document.createElement("div");
                animalCol.id = "searchAnimalsDiv";
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

                output.prepend(animalCol);
            }
        })
        .catch(err => console.error(err));

    
});