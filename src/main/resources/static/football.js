'use strict'

const output = document.getElementById("output");
let teamId;

var myModal = new bootstrap.Modal(document.getElementById('exampleModal'), {
    keyboard: false
})

function getTeams() {
    axios.get("/getTeams")
        .then(res => {
            output.innerHTML = "";

            const teams = res.data;

            teams.forEach(team => {
                const newTeam = renderTeam(team);
                console.log("New team: ", newTeam);
                output.appendChild(newTeam);
            });
        }).catch(err => console.error(err));
}


function renderTeam(team) {
    const newRow = document.createElement("tr");

    const name = document.createElement("td");
    name.innerText = team.teamName;
    newRow.appendChild(name);

    const captain = document.createElement("td")
    captain.innerText = team.captain;
    newRow.appendChild(captain);

    const kit = document.createElement("td")
    kit.innerText = team.kitColour;
    newRow.appendChild(kit);

    const squad = document.createElement("td")
    squad.innerText = team.squadSize;
    newRow.appendChild(squad);

    const location = document.createElement("td")
    location.innerText = team.location;
    newRow.appendChild(location);

    const contact = document.createElement("td")
    contact.innerText = team.contactDetails;
    newRow.appendChild(contact);

    const action = document.createElement("td")
    newRow.appendChild(action);

    const deleteTeamButton = document.createElement("i");
    deleteTeamButton.className = "fas fa-trash-alt icon trash"
    deleteTeamButton.setAttribute("title", "Delete team");
    deleteTeamButton.addEventListener('click', () => deleteTeam(team.id));
    action.appendChild(deleteTeamButton);

    const updateTeamButton = document.createElement("i");
    updateTeamButton.className = "fas fa-edit icon"
    updateTeamButton.setAttribute("title", "Update team")
    updateTeamButton.addEventListener("click", function () {
        myModal.toggle();
        teamId = team.id;
    })
    action.appendChild(updateTeamButton);
    newRow.appendChild(action);

    return newRow;
}

document.getElementById("teamForm").addEventListener('submit', function (event) {
    event.preventDefault();

    const data = {
        teamName: this.name.value,
        captain: this.captain.value,
        kitColour: this.kit.value,
        squadSize: this.squad.value,
        location: this.location.value,
        contactDetails: this.contact.value
    };

    if (isNaN(data.squadSize) || data.squadSize < 1 || data.squadSize > 10) {
        alert("Please enter a valid squad size. A valid squad is between 1-10 players.")
    } else if (data.teamName && data.captain && data.kitColour && data.squadSize && data.location && data.contactDetails) {
        
        axios.post("/createTeam", data)
            .then(() => {
                this.reset();
                this.name.focus();
                getTeams();
            })
            .catch(err => console.error(err));
    } else {
        alert("Please fill out all of the fields to submit your team.")
    }

})

function deleteTeam(id) {
    axios.delete("/deleteTeam/" + id)
        .then(() => getTeams())
        .catch(err => console.error(err));
}

document.getElementById("teamUpdateForm").addEventListener('submit', function (event) {
    event.preventDefault();

    const data = {
        teamName: this.name.value,
        captain: this.captain.value,
        kitColour: this.kit.value,
        squadSize: this.squad.value,
        location: this.location.value,
        contactDetails: this.contact.value
    }; 

    axios.put("/updateTeam/" + teamId, data, {

    }).then(() => {
        this.reset();
        myModal.toggle();
        getTeams();
    }).catch(err => console.error(err));
});

getTeams()