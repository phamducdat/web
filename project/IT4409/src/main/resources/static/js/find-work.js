function getJobSearchResultsViaAjax() {
    var input = document.getElementById('search');
    var keyword = input.value;
    if (keyword !== "") {

        var url = "api/job?search=title:" + keyword + "&page=0&size=5&sortBy=default";
        var xhr  = new XMLHttpRequest();
        xhr.open("GET", url, true);
        xhr.onload = function () {
            var resp = JSON.parse(xhr.responseText);
            if (xhr.readyState == 4 && xhr.status == "200") {
                if (resp.msg) {
                    var root = document.getElementById("search-result");
                    root.style.display = "block";
                    root.innerHTML = "";
                    resp.links.forEach(function (job) {
                        var str = "<div class='row'>" + "<i class='fas fa-search' style='color: #A9A9A9'></i>&nbsp;&nbsp;"
                        + "<a href='/find-work/recommended/"+ job.id +"'>" + job.title + "</a>" + "</div>";
                        root.insertAdjacentHTML( 'beforeend', str);
                    });
                } else {
                    root.document.getElementById("search-result").style.display = "none";
                }
            } else {

            }
        }
        xhr.send();
    } else {
        document.getElementById("search-result").style.display = "none";
    }
}

var ignoreClickOnMeElement = document.getElementById('container-search');

document.addEventListener('click', function(event) {
    var isClickInsideElement = ignoreClickOnMeElement.contains(event.target);
    if (!isClickInsideElement) {
        document.getElementById("search-result").style.display = "none";
    }
});

function getJobs() {
    var page;
    if (sessionStorage.getItem("page")) {
        page = parseInt(sessionStorage.getItem("page")) + 1;
        sessionStorage.setItem("page", page);
    }
    else {
        page = 0;
        sessionStorage.setItem("page", page);
    }
    var size = 3;
    var url = "api/job?search&page=" + page + "&size=" + size + "&sortBy=default";
    var request = new XMLHttpRequest();
    request.open("GET", url, true);
    request.onload = function () {
        var resp = JSON.parse(request.responseText);
        if (request.readyState == 4 && request.status == "200") {
            var jobs = resp.links;
            addJob(jobs);
            var msg = resp.msg;
            if (msg === 'end') document.getElementById("load-more").style.display = "none";
        }
    }
    request.send();
}

document.addEventListener("DOMContentLoaded", function(event) {
    getJobs();
    var local = localStorage.getItem("recent");
    if (local) {
        root = document.getElementById("recent-searches");
        var recentSearches = JSON.parse(local);
        recentSearches.forEach(function (item) {
            var str = "<li><a href='/f/search?q=" + item + "'class='green'>" + item + "</a></li>";
            root.insertAdjacentHTML( 'beforeend', str);
        });
    }
});

function addJob(jobs) {
    var root = document.getElementById("center");
    jobs.forEach(function(element) {

        var id = element.id;
        var title = element.title;
        var des = element.description;
        var expertiseLevel = capitalizeFirstLetter(element.expertiseLevel);
        var author = element.author ? element.author.fullname : "";
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
        "<span>Author: " + author + "</span>" + "</small>" + "</div>" + "<div>" + "<small>"
        + "<i class='fa fa-check-circle' aria-hidden='true'></i>" + "<span>Payment unverified</span>" + "&nbsp;"
        + "<span class='fa fa-star checked'></span>" + "<span class='fa fa-star checked'></span>" +
        "<span class='fa fa-star checked'></span>" + "<span class='fa fa-star'></span>" + "<span class='fa fa-star'></span>"
        + "&nbsp;" +"<span> $0 spent</span>" + "&nbsp;" +"<i class='fa fa-map-marker' aria-hidden='true'></i>" + "<span> Vietnam</span>"
        + "</small>" + "</div" + "</div>";
        root.insertAdjacentHTML( 'beforeend', job);
    });
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

window.onunload = function() {
    sessionStorage.removeItem('page');
}

function goToSearch() {
    keyword = document.getElementById('search').value;
    var local = localStorage.getItem("recent");
    var recentSearches;
    if (local) {
        recentSearches = JSON.parse(local);
        recentSearches.push(keyword);
        if (recentSearches.length === 6) recentSearches.shift();

    } else {
        recentSearches = [keyword];
    }
    localStorage.setItem("recent", JSON.stringify(recentSearches));
    window.location.href = '/f/search?q=' + keyword;
}

var headerSearch = document.getElementById("header-search");

headerSearch.addEventListener("keyup", function(event) {
  if (event.keyCode === 13) {
    event.preventDefault();
    keyword = headerSearch.value;
    var local = localStorage.getItem("recent");
    var recentSearches;
    if (local) {
        recentSearches = JSON.parse(local);
        recentSearches.push(keyword);
        if (recentSearches.length === 6) recentSearches.shift();

    } else {
        recentSearches = [keyword];
    }
    localStorage.setItem("recent", JSON.stringify(recentSearches));
    window.location.href = '/f/search?q=' + keyword;
  }
});

function capitalizeFirstLetter(string) {
  return string.charAt(0).toUpperCase() + string.slice(1);
}