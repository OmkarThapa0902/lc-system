document.getElementById("lcForm").addEventListener("submit", function (event) {
    event.preventDefault();

    const lcData = {
        applicant: document.getElementById("applicant").value,
        beneficiary: document.getElementById("beneficiary").value,
        amount: parseFloat(document.getElementById("amount").value),
        currency: document.getElementById("currency").value,
        issueDate: new Date().toISOString(),
        status: "Pending"
    };

    fetch("http://localhost:8080/api/lcs", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(lcData),
    })
        .then(response => response.json())
        .then(data => {
            alert("Letter of Credit created successfully!");
            fetchLCs(); // Refresh the list after submission
        })
        .catch(error => console.error("Error:", error));
});

function fetchLCs() {
    fetch("http://localhost:8080/api/lcs")
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector("#lcTable tbody");
            tableBody.innerHTML = ""; // Clear existing rows

            data.forEach(lc => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${lc.id}</td>
                    <td>${lc.applicant}</td>
                    <td>${lc.beneficiary}</td>
                    <td>${lc.amount}</td>
                    <td>${lc.currency}</td>
                    <td>${new Date(lc.issueDate).toLocaleDateString()}</td>
                    <td>${lc.status}</td>
                `;
                tableBody.appendChild(row);
            });
        });
}

// Fetch LCs on page load
window.onload = fetchLCs;
