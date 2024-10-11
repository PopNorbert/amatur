import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ContestListComponent } from './contest-list/contest-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ContestListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'amatur-ui';
}
