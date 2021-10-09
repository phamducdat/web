var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    var content = this.parentElement.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}

function getJobs() {
    var page;
    if (sessionStorage.getItem("page-search")) {
        page = parseInt(sessionStorage.getItem("page-search")) + 1;
        sessionStorage.setItem("page-search", page);
    }
    else {
        page = 0;
        sessionStorage.setItem("page-search", page);
    }
    var size = 3;
    var url = "/api/job?search=";
    var keyword = document.getElementById("search").value;
    if (keyword) url += "title:" + keyword;
    var level = getRadioValue("radio-level");
    if (level) url += ",expertiseLevel:" + level;
    var type = getRadioValue("radio-type");
    if (type) url += ",type:" + type;
    url = custom(url);
    url += "&page=" + page + "&size=" + size;
    var sortBy = document.getElementById('sort').value;
    url += "&sortBy=" + sortBy;
    console.log(url);
    var request = new XMLHttpRequest();
    request.open("GET", url, true);
    request.onload = function () {
        var resp = JSON.parse(request.responseText);
        if (request.readyState == 4 && request.status == "200") {
            var jobs = resp.links;
            document.getElementById("number-job-found").textContent = resp.total;
            addJob(jobs);
            var msg = resp.msg;
            if (msg === 'end') document.getElementById("load-more").style.display = "none";
            else  document.getElementById("load-more").style.display = "block";
        }
    }
    request.send();
}

function getRadioValue(name) {
            var ele = document.getElementsByName(name);

            for(i = 0; i < ele.length; i++) {
                if(ele[i].checked) return ele[i].value;
            }
        }
function custom(url) {
    var option = getRadioValue("radio-budget");
    if (option == 1) {
        url += ",budget<50";
    } else if (option == 2) {
        url += ",budget<50,budget>100";
    } else if (option == 3) {
        url += ",budget>100";
    }
    return url;
}

function addJob(jobs) {
    var root = document.getElementById("listJobs");
    jobs.forEach(function(element) {

        var id = element.id;
        var title = element.title;
        var des = element.description;
        var expertiseLevel = capitalizeFirstLetter(element.expertiseLevel);
        var author = element.author;
        var budget = element.budget;
        var createdTime = formatDate(element.createdTime);
        var type = capitalizeFirstLetter(element.type);
        var timeRequirement = capitalizeFirstLetter(element.timeRequirement);
        var skill = capitalizeFirstLetter(element.skill);

        var link = "/find-work/recommended/" + id;
        var job = "<div class='job'>" + "<div class='head'>" + "<h4><a href='" + link + "'>" + title + "</a></h4>"
        + "<ul>" + "<li>" + "<button class='button'>" + "<div class='up-icon'>" + "<i class='fas fa-thumbs-down'></i>"
        + "</div>" + "</button>" + "</li>" + "<li>" + "<button class='button'>" + "<div class='up-icon'>" +
        "<i class='fas fa-heart'></i>" + "</div>" + "</button>" + "</li>" + "</ul>" + "</div>" +
        "<div>" + "<small>" + "<span>" + type +" </span>" +
        "<span>Budget: $" + budget +" </span>" + "<span>- " + expertiseLevel + " </span>"
        + "<span>- Time Requirement: " + timeRequirement + " </span>" + "<span>- Created time: " + createdTime + " </span>"
        + "</small>" + "</div>" + "<p>" + des + "</p>" + "<div class='skills'>" + "<div class='skill'>"
        + "<a href='#'>" + skill + "</a>" + "</div>" + "</div>" + "<div>" + "<small>" +
        "<span>Author: " + "</span>" + "</small>" + "</div>" + "<div>" + "<small>"
        + "<i class='fa fa-check-circle' aria-hidden='true'></i>" + "<span>Payment unverified</span>" + "&nbsp;"
        + "<span class='fa fa-star checked'></span>" + "<span class='fa fa-star checked'></span>" +
        "<span class='fa fa-star checked'></span>" + "<span class='fa fa-star'></span>" + "<span class='fa fa-star'></span>"
        + "&nbsp;" +"<span> $0 spent</span>" + "&nbsp;" +"<i class='fa fa-map-marker' aria-hidden='true'></i>" + "<span> Vietnam</span>"
        + "</small>" + "</div" + "</div>";
        root.insertAdjacentHTML( 'beforeend', job);
    });
}

window.onunload = function() {
    sessionStorage.removeItem('page-search');
}

function capitalizeFirstLetter(string) {
  return string.charAt(0).toUpperCase() + string.slice(1);
}

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}

document.addEventListener("DOMContentLoaded", function(event) {
    getJobs();
});

function search() {
    document.getElementById("listJobs").innerHTML = "";
    sessionStorage.removeItem('page-search');
    getJobs();
}