// script.js
const lcForm = document.getElementById('lcForm');
const lcTableBody = document.querySelector('#lcTable tbody');

// Fetch and display all letters of credit when the page loads
document.addEventListener('DOMContentLoaded', fetchLettersOfCredit);

// Handle form submission for create/update
lcForm.addEventListener('submit', async function (event) {
    event.preventDefault();

    const lcId = document.getElementById('lcId').value;
    const applicantId = document.getElementById('applicantId').value;
    const beneficiaryId = document.getElementById('beneficiaryId').value;
    const productId = document.getElementById('productId').value;
    const issueDate = document.getElementById('issueDate').value;
    const dueDate = document.getElementById('dueDate').value;
    const status = document.getElementById('status').value;

    const letterOfCredit = {
        applicant: { id: applicantId },
        beneficiary: { id: beneficiaryId },
        product: { id: productId },
        issueDate,
        dueDate,
        status
    };

    if (lcId) {
        // Update existing Letter of Credit
        await updateLetterOfCredit(lcId, letterOfCredit);
    } else {
        // Create new Letter of Credit
        await createLetterOfCredit(letterOfCredit);
    }

    lcForm.reset();
    fetchLettersOfCredit();
});

// Fetch all letters of credit
async function fetchLettersOfCredit() {
    const response = await fetch('/api/lettersOfCredit');
    const lettersOfCredit = await response.json();
    lcTableBody.innerHTML = '';
    lettersOfCredit.forEach(lc => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${lc.id}</td>
            <td>${lc.applicant.id}</td>
            <td>${lc.beneficiary.id}</td>
            <td>${lc.product.id}</td>
            <td>${lc.issueDate}</td>
            <td>${lc.dueDate}</td>
            <td>${lc.status}</td>
            <td>
                <button onclick="editLetterOfCredit(${lc.id})">Edit</button>
                <button class="delete" onclick="deleteLetterOfCredit(${lc.id})">Delete</button>
            </td>
        `;
        lcTableBody.appendChild(row);
    });
}

// Create new Letter of Credit
async function createLetterOfCredit(letterOfCredit) {
    await fetch('/api/lettersOfCredit', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(letterOfCredit)
    });
}

// Update an existing Letter of Credit
async function updateLetterOfCredit(lcId, letterOfCredit) {
    await fetch(`/api/lettersOfCredit/${lcId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(letterOfCredit)
    });
}

// Delete Letter of Credit
async function deleteLetterOfCredit(lcId) {
    await fetch(`/api/lettersOfCredit/${lcId}`, {
        method: 'DELETE'
    });
    fetchLettersOfCredit();
}

// Populate form for editing
async function editLetterOfCredit(lcId) {
    const response = await fetch(`/api/lettersOfCredit/${lcId}`);
    const letterOfCredit = await response.json();

    document.getElementById('lcId').value = letterOfCredit.id;
    document.getElementById('applicantId').value = letterOfCredit.applicant.id;
    document.getElementById('beneficiaryId').value = letterOfCredit.beneficiary.id;
    document.getElementById('productId').value = letterOfCredit.product.id;
    document.getElementById('issueDate').value = letterOfCredit.issueDate;
    document.getElementById('dueDate').value = letterOfCredit.dueDate;
    document.getElementById('status').value = letterOfCredit.status;
}
