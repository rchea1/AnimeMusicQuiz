var query = `
query ($title: String) {
  Media (search: $title, type: ANIME) {
    season
    startDate{year}
    title {
      romaji
      english
    }
  }
}
`;

function executeQuery() {
    var variables = {
        title: $('.new-anime-input').val()
    }

    var url = 'https://graphql.anilist.co',
        options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
            },
            body: JSON.stringify({
                query: query,
                variables: variables
            })
        };

    fetch(url, options).then(handleResponse)
                       .then(handleData) 
                       .catch(handleError);
}

function handleResponse(response) {
    return response.json().then(function(json) {
        return response.ok ? json : Promise.reject(json);
    });
}

function handleData(data) {
    $('#animeTitleInput').val(data.data.Media.title.romaji);
    $('#premiereYearInput').val(data.data.Media.startDate.year);
    $('#premiereSeasonInput').val(formatSeason(data.data.Media.season));
}

function handleError(error) {
    alert('Error, check console');
    console.log(error);
}

function formatSeason(season) {
    return season.replace(/\w\S*/g, function (word) {
        return word.charAt(0) + word.slice(1).toLowerCase();
    });
}

