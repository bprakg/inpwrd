# inpwrd
inpwrd url analysis challenge api
Heres how it is tested

GET localhost:8080/urlanalysis?url=https://www.google.com

POST localhost:8080/urlanalysis
payload 
{
	"url":"https://www.google.com",
	"callbackUrl":"https://inpwrd.com/results"
}

