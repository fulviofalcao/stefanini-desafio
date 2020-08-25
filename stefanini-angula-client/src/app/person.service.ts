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
    let tokenParse = JSON.parse(`${this.access_token}`)
    return this.http.get(`${this.baseUrl}/${id}`, { headers:new HttpHeaders().append('Authorization', `Bearer ${tokenParse}`)});
  }

  createPerson(person: Object): Observable<Object> {
    let tokenParse = JSON.parse(`${this.access_token}`)
    return this.http.post(`${this.baseUrl}`, person, { headers:new HttpHeaders().append('Authorization', `Bearer ${tokenParse}`)});
  }

  updatePerson(id: number, value: any): Observable<Object> {
    let tokenParse = JSON.parse(`${this.access_token}`)
    return this.http.put(`${this.baseUrl}/${id}`, value, { headers:new HttpHeaders().append('Authorization', `Bearer ${tokenParse}`)});
  }

  deletePerson(id: number): Observable<any> {
    let tokenParse = JSON.parse(`${this.access_token}`)
    return this.http.delete(`${this.baseUrl}/${id}`, { headers:new HttpHeaders().append('Authorization', `Bearer ${tokenParse}`)});
  }

  getPersonsList(): Observable<any> {
    let tokenParse = JSON.parse(`${this.access_token}`)  
    return this.http.get(`${this.baseUrl}`, { headers:new HttpHeaders().append('Authorization', `Bearer ${tokenParse}`)});
  }
}
