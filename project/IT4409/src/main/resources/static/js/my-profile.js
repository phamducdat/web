const tabBtn = document.querySelectorAll(".tab");
const tab = document.querySelectorAll(".tabShow");
console.log(tabBtn);
function tabs(paneIndex) {
    tab.forEach(function (node) {
        node.style.display = "none";
    });
    tab[paneIndex].style.display = "block";
    tabBtn.forEach(function (node) {
        node.classList.remove('active');
    });
    tabBtn[paneIndex].classList.add('active');
}
tabs(0);

function info() {
    var fullname = document.getElementById('fullname').value
        birthday = document.getElementById('birthday').value,
        gender = document.getElementById('gender').value,
        email = document.getElementById('email').value,
        password = document.getElementById('password').value,
        id = document.getElementById('id').value,
        education = document.getElementById('education').textContent,
        phone = document.getElementById('phone').textContent,
        company = document.getElementById('company').textContent,
        country = document.getElementById('country').value,
        review = document.getElementById('review').value,
        rates = document.getElementById('rates').value,
        skills = document.getElementById('skills').value;

    var user = {
        id,
        fullname,
        birthday,
        gender,
        email,
        password,
        education,
        phone,
        company,
        country,
        review,
        rates,
        skills
    };

    console.log(user);
    var url = "api/user/" + id;
        var xhr  = new XMLHttpRequest();
        var data = JSON.stringify(user);
        xhr.open("PUT", url, true);
        xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
        xhr.onload = function () {
    	if (xhr.readyState == 4 && xhr.status == "200") {
    	   console.log('success');
    	   document.getElementById('success').style.display = "block";
    	   setTimeout(function(){ document.getElementById('success').style.display = "none"; }, 3000);

    	} else {
    	   console.log('error');
    	}
    }
    xhr.send(data);
}

var x, i, j, l, ll, selElmnt, a, b, c;
/*look for any elements with the class "custom-select":*/
x = document.getElementsByClassName("custom-select");
l = x.length;
for (i = 0; i < l; i++) {
  selElmnt = x[i].getElementsByTagName("select")[0];
  ll = selElmnt.length;
  /*for each element, create a new DIV that will act as the selected item:*/
  a = document.createElement("DIV");
  a.setAttribute("class", "select-selected");
  a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
  x[i].appendChild(a);
  /*for each element, create a new DIV that will contain the option list:*/
  b = document.createElement("DIV");
  b.setAttribute("class", "select-items select-hide");
  for (j = 1; j < ll; j++) {
    /*for each option in the original select element,
    create a new DIV that will act as an option item:*/
    c = document.createElement("DIV");
    c.innerHTML = selElmnt.options[j].innerHTML;
    c.addEventListener("click", function(e) {
        /*when an item is clicked, update the original select box,
        and the selected item:*/
        var y, i, k, s, h, sl, yl;
        s = this.parentNode.parentNode.getElementsByTagName("select")[0];
        sl = s.length;
        h = this.parentNode.previousSibling;
        for (i = 0; i < sl; i++) {
          if (s.options[i].innerHTML == this.innerHTML) {
            s.selectedIndex = i;
            h.innerHTML = this.innerHTML;
            y = this.parentNode.getElementsByClassName("same-as-selected");
            yl = y.length;
            for (k = 0; k < yl; k++) {
              y[k].removeAttribute("class");
            }
            this.setAttribute("class", "same-as-selected");
            break;
          }
        }
        h.click();
    });
    b.appendChild(c);
  }
  x[i].appendChild(b);
  a.addEventListener("click", function(e) {
      /*when the select box is clicked, close any other select boxes,
      and open/close the current select box:*/
      e.stopPropagation();
      closeAllSelect(this);
      this.nextSibling.classList.toggle("select-hide");
      this.classList.toggle("select-arrow-active");
    });
}
function closeAllSelect(elmnt) {
  /*a function that will close all select boxes in the document,
  except the current select box:*/
  var x, y, i, xl, yl, arrNo = [];
  x = document.getElementsByClassName("select-items");
  y = document.getElementsByClassName("select-selected");
  xl = x.length;
  yl = y.length;
  for (i = 0; i < yl; i++) {
    if (elmnt == y[i]) {
      arrNo.push(i)
    } else {
      y[i].classList.remove("select-arrow-active");
    }
  }
  for (i = 0; i < xl; i++) {
    if (arrNo.indexOf(i)) {
      x[i].classList.add("select-hide");
    }
  }
}
/*if the user clicks anywhere outside the select box,
then close all select boxes:*/
document.addEventListener("click", closeAllSelect);

var modal = document.getElementById("myModal");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal

function openModal(id) {
    modal.style.display = "block";
    var label;
    var idModal;
    var placeholder;
    var value;
    if (id === 'btn-edu') {
        label = "Education"; idModal = "medu"; placeholder="Your school..";
        value = document.getElementById('education').textContent;
    } else if (id === 'btn-phone') {
        label = "Phone"; idModal = "mphone"; placeholder="Your phone..";
        value = document.getElementById('phone').textContent;
    } else if (id === 'btn-company') {
        label = "Company"; idModal = "mcompany"; placeholder="Your company..";
        value = document.getElementById('company').textContent;
    }
    var str = "<label for=" +idModal + ">" + label +  "</label>"
    + "<input value='" + value + "'class='modal-input' type='text' id=" + idModal + " placeholder='" + placeholder + "'>"
    + "<input class='modal-submit' onclick='submit()' type='submit' value='Submit'>";
    var root = document.getElementById('input-wrapper');
    root.innerHTML = '';
    root.insertAdjacentHTML( 'beforeend', str);
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

function submit() {
    var id = document.getElementsByClassName('modal-input')[0].id;
    var value = document.getElementsByClassName('modal-input')[0].value;
    var root;
    if (id === 'medu') {
        root = document.getElementById('education');
    } else if (id === 'mphone') {
        root = document.getElementById('phone');
    } else if (id === 'mcompany') {
        root = document.getElementById('company');
    }
    root.innerHTML = value;
    modal.style.display = "none";
}

