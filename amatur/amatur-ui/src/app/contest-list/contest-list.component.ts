// my-list.component.ts
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contest-list',
  standalone:true,
  templateUrl: './contest-list.component.html',
  styleUrls: ['./contest-list.component.css']
})
export class ContestListComponent implements OnInit {

  dataList: any[] = [];  // Store the data in an array

  constructor() { }

  ngOnInit(): void {
    // Fetch data from the API
    fetch('http://localhost:8080/api/contests')  // Replace with actual API URL
      .then(response => response.json())
      .then(data => {
        this.dataList = data;  // Assign the data to the array
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }

}
