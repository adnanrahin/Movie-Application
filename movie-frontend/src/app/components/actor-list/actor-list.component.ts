import { ActorService } from '../../services/actor.service';
import { Component, OnInit } from '@angular/core';
import { Actor } from 'src/app/model/actor';

@Component({
  selector: 'app-actor-list',
  templateUrl: './actor-list.component.html',
  styleUrls: ['./actor-list.component.css']
})
export class ActorListComponent implements OnInit {

  actorList: Actor[] = [];

  constructor(private actorService: ActorService) { }

  ngOnInit(): void {
    this.actorService.findAll().subscribe(data => {
      this.actorList = data;
    });
  }

}
