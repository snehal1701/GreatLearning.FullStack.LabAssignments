//3 params, questions, score, currQuestIndex
function Quiz(questions) {
  this.score = 0;
  this.currQuestIndex = 0;
  this.questions = questions;
}
function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}
let freezeClic = false; // just modify that variable to disable all clics events

document.addEventListener("click", e => {
  if (freezeClic) {
    e.stopPropagation();
    e.preventDefault();
  }
}, true);

Quiz.prototype.getCurrentQuestionIndex = function () {
  return this.questions[this.currQuestIndex];
};

Quiz.prototype.isEnded = function () {
  return this.currQuestIndex === this.questions.length;
};

//Function will 3 things
// 1. Validate the answer
// 2. Update the score
// 3. Increment the current index
Quiz.prototype.validateAnswerAndUpdateScore = function (btn, choice) {
  let question = this.getCurrentQuestionIndex();
  if (question.answer === choice) {
    this.score++;
    btn.style.background = 'green';
  }
  else {
    btn.style.background = 'red';
  }
  this.currQuestIndex++;

};

function Question(text, options, answer) {
  this.text = text;
  this.options = options;
  this.answer = answer;
}

let questions = [
  new Question(
    "Who is the current PM of India?",
    ["Narenda Modi", "Jawaharlal Nehru", "Pratibha Patil", "Adbul Kalam"],
    "Narenda Modi"
  ),
  new Question(
    "Whats the National bird of India?",
    ["Piegon", "Peocock", "Koyal", "Crow"],
    "Peocock"
  ),
  new Question(
    "Which is not a JavaScript Framework?",
    ["Python Script", "JQuery", "Django", "NodeJS"],
    "Django"
  )
];

function showScores() {
  console.log("Scores :-", quiz.score);
  let gameOverHTML = "<h1>Result</h1>";
  gameOverHTML += `<h2 id='score'> Your Scores:- ${quiz.score
    } and mark percentage is :- ${(quiz.score / questions.length).toFixed(2) * 100}% </h1>`;
  document.getElementById("quiz").innerHTML = gameOverHTML;
}

function loadQuestions() {
  if (quiz.isEnded()) {
    showScores();
  } else {
    freezeClic = false;
    //Show current question!
    let curQuest = quiz.getCurrentQuestionIndex();
    if (curQuest.text) {
      let questionEle = document.getElementById("question");
      questionEle.innerHTML = curQuest.text;

      //Show current question's options
      let options = curQuest.options;
      for (var i = 0; i < options.length; i++) {
        let currOption = options[i];
        let eachOptElement = document.getElementById("choice" + i);
        eachOptElement.innerHTML = currOption;
        handleOptionBtn("btn" + i, currOption);
      }
    }
    showProgress();
  }
}

function showProgress() {
  let curQuestNumber = quiz.currQuestIndex + 1;
  let progress = document.getElementById("progress");
  progress.innerHTML = `Question ${curQuestNumber} of ${quiz.questions.length}`;
}

function handleOptionBtn(btnId, choice) {
  let btn = document.getElementById(btnId);
  btn.style.background = '';
  btn.onclick = async () => {
    freezeClic = true;
    quiz.validateAnswerAndUpdateScore(btn, choice);
    await sleep(3000);
    loadQuestions();
  };
}

let quiz = new Quiz(questions);

//Load questions
loadQuestions();
