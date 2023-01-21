const addFormEl = document.getElementById('addForm');

const nameAddInputEl = addFormEl.querySelector('input[id="name"]');
const birthAddInputEl = addFormEl.querySelector('input[id="birth"]');
const phoneAddInputEl = addFormEl.querySelector('input[id="phone"]');
const addressAddInputEl = addFormEl.querySelector('input[id="address"]');
const genderAddInputEl = addFormEl.querySelector('input[id="gender"]');

const actionFormAddEl = document.getElementById('actionAddForm')

const nameActionAddInputEl = actionFormAddEl.querySelector('input[name="name"]');
const birthActionAddInputEl = actionFormAddEl.querySelector('input[name="birth"]');
const phoneActionAddInputEl = actionFormAddEl.querySelector('input[name="phone"]');
const addressActionAddInputEl = actionFormAddEl.querySelector('input[name="address"]');
const genderActionAddInputEl = actionFormAddEl.querySelector('input[name="gender"]');

function maleRbAddOnClick(){
    genderActionAddInputEl.value = 'm'
    genderAddInputEl.value = 'm'
};

function femaleRbAddOnClick(){
    genderActionAddInputEl.value = 'f'
    genderAddInputEl.value = 'f'
};

function dataToActionAdd(){
    document.getElementById('required').click()
    nameActionAddInputEl.value = nameAddInputEl.value
    birthActionAddInputEl.value = birthAddInputEl.value
    phoneActionAddInputEl.value = phoneAddInputEl.value
    addressActionAddInputEl.value = addressAddInputEl.value
};

// ---

const editFormEl = document.querySelector('#edit-form');

const nameInputEl = editFormEl.querySelector('input[id="name"]');
const birthInputEl = editFormEl.querySelector('input[id="birth"]');
const phoneInputEl = editFormEl.querySelector('input[id="phone"]');
const addressInputEl = editFormEl.querySelector('input[id="address"]');
const genderInputEl = editFormEl.querySelector('input[id="gender"]');

const maleRbEl = editFormEl.querySelector('#addMaleRB');
const femaleRbEl = editFormEl.querySelector('#addFemaleRB');

const actionFormEl = document.getElementById('actionForm')

const nameActionInputEl = actionFormEl.querySelector('input[name="name"]');
const birthActionInputEl = actionFormEl.querySelector('input[name="birth"]');
const phoneActionInputEl = actionFormEl.querySelector('input[name="phone"]');
const addressActionInputEl = actionFormEl.querySelector('input[name="address"]');
const genderActionInputEl = actionFormEl.querySelector('input[name="gender"]');


[...document.querySelectorAll('input[value="Edit"]')].forEach(editBtnEl => {
    editBtnEl.onclick = () => {

        if (document.getElementById('addForm').style.display === 'flex'){
            document.getElementById('addForm').style.display='none'
        }

        document.getElementById('editForm').style.display='flex'

        const rowEl = editBtnEl.closest("tr")

        const name = rowEl.querySelector('.name').innerText.trim()
        const birth = rowEl.querySelector('.birth').innerText.trim()
        const phone = rowEl.querySelector('.phone').innerText.trim()
        const address = rowEl.querySelector('.address').innerText.trim()
        const gender = rowEl.querySelector('.gender').innerText.trim()

        nameInputEl.value = name
        birthInputEl.value = birth
        phoneInputEl.value = phone
        addressInputEl.value = address


        nameActionInputEl.value = nameInputEl.value
        birthActionInputEl.value = birthInputEl.value
        phoneActionInputEl.value = phoneInputEl.value
        addressActionInputEl.value = addressInputEl.value

        switch (gender) {
            case 'm': {
                maleRbEl.click()
                break
            }
            case 'f': {
                femaleRbEl.click()
                break
            }
        }
    }
})

function maleRbOnClick(){
    genderActionInputEl.value = 'm'
};

function femaleRbOnClick(){
    genderActionInputEl.value = 'f'
};


function dataToAction(){
    nameActionInputEl.value = nameInputEl.value
    birthActionInputEl.value = birthInputEl.value
    phoneActionInputEl.value = phoneInputEl.value
    addressActionInputEl.value = addressInputEl.value
}