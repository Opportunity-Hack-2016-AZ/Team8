// Global variables declarations
var apiEndPoint = 'http://localhost:5252'

// hitting the endpoint
function httpGetAsync(theUrl, callback, rType, parameters){
    $.ajax({
      url: theUrl,
      type: rType,
      dataType: "json",
      data: parameters,
      success: function(data, status){
            callback({'data':data, 'status':status});
      }
    });
}

//formatting the urlStrings

function formatString(type){
  if (type == 'profile'){
      return apiEndPoint + '/profile';
  } else if (type == 'team'){
      return apiEndPoint + '/team'
  } else if (type == 'login'){
      return apiEndPoint + '/login'
  } else if (type == 'logmiles'){
      return apiEndPoint + '/logmiles'
  }
}

function callServer(type, variables, callback){
    url = formatString(type);
    if(type == 'logMiles'){
        httpGetAsync(url, callback, 'post', variables)
    } else {
        httpGetAsync(url, callback, 'get', variables)
    }

}
