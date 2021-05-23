Assumptions:

1. There would be a separate microservice (Authentication Server) which will provide the API token.
2. To call ATM microservice, authorization bearer token will be needed.
3. Before serving the request, ATM microservice will authenticate the authorization bearer token from Authentication Server (every call).
4. In the code, token is hard-coded with "27f685a5-19bd-4522-8d1b-acbc5ea9ca32".

Account:
1. Aadhaar Card is mandatory to register.

