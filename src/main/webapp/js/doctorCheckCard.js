function displayForm(){
    document.getElementById('createForm').style.display = 'flex'
};

function closeForm(){
    document.getElementById('createForm').style.display = 'none'
};

const actionFormAddEl = document.getElementById('actionForm')

const diagnosisActionAddInputEl = actionFormAddEl.querySelector('input[name="diagnosis"]');
const treatmentCourseActionAddInputEl = actionFormAddEl.querySelector('input[name="treatmentCourse"]');

const createFormEl = document.getElementById('createForm');

const diagnosisInputEl = createFormEl.querySelector('input[id="diagnosis"]');
const treatmentCourseInputEl = createFormEl.querySelector('input[id="treatmentCourse"]');

function dataToAction(){
    document.getElementById('required').click()
    diagnosisActionAddInputEl.value = diagnosisInputEl.value
    treatmentCourseActionAddInputEl.value = treatmentCourseInputEl.value

}
