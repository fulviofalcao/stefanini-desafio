import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private baseUrl = 'http://localhost:8080/stefanini-api-rest/api/v1/persons';
  private access_token = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5ODk1OTk1NH0.ADhFFN5GetWQqoBLfpXr28dqo4m4l9iTh8hmD-8bj5nABXdan9e9ng5uvwBXvGBc-BETZAiDyt9rgCCGk7nkgQ'


  constructor(private http: HttpClient) { }

  getPerson(id: number): Observable<any> {
    var reqHeader = new HttpHeaders({ 
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(localStorage.getItem(`${this.access_token}`))
   });
    return this.http.get(`${this.baseUrl}/${id}`, { headers: reqHeader });
  }

  createPerson(person: Object): Observable<Object> {
    var reqHeader = new HttpHeaders({ 
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(localStorage.getItem(`${this.access_token}`))
    });
    return this.http.post(`${this.baseUrl}`, person, { headers: reqHeader });
  }

  updatePerson(id: number, value: any): Observable<Object> {
    var reqHeader = new HttpHeaders({ 
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(localStorage.getItem(`${this.access_token}`))
    });
    return this.http.put(`${this.baseUrl}/${id}`, value, { headers: reqHeader });
  }

  deletePerson(id: number): Observable<any> {
    var reqHeader = new HttpHeaders({ 
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(localStorage.getItem(`${this.access_token}`))
    });
    return this.http.delete(`${this.baseUrl}/${id}`, { headers: reqHeader });
  }

  getPersonsList(): Observable<any> {
    var reqHeader = new HttpHeaders({ 
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(localStorage.getItem(`${this.access_token}`))
    });
    return this.http.get(`${this.baseUrl}`, { headers: reqHeader });
  }
}
