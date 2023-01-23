function displayForm(){
    document.getElementById('createForm').style.display = 'flex'
};

function closeForm(){
    document.getElementById('createForm').style.display = 'none'
};

const actionFormAddEl = document.getElementById('actionForm')

const reasonActionAddInputEl = actionFormAddEl.querySelector('input[name="reason"]');
const fromActionAddInputEl = actionFormAddEl.querySelector('input[name="time_from"]');
const toActionAddInputEl = actionFormAddEl.querySelector('input[name="time_to"]');

const createFormEl = document.getElementById('createForm');

const reasonInputEl = createFormEl.querySelector('input[id="reason"]');
const fromInputEl = createFormEl.querySelector('input[id="time_from"]');
const toInputEl = createFormEl.querySelector('input[id="time_to"]');

function dataToAction(){
    document.getElementById('checkBt').click()
    reasonActionAddInputEl.value = reasonInputEl.value
    fromActionAddInputEl.value = fromInputEl.value
    toActionAddInputEl.value = toInputEl.value

}
