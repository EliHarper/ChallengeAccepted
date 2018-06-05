import { Router, ActivatedRoute } from '@angular/router';
import { InboxService } from './../inbox.service';
import { Component, OnInit } from '@angular/core';
import { Message } from '../models/message';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent implements OnInit {

  allMessages: Message[] = [];
  threadMessages: Message[] = [];

  getAllMessageHeadsOfUser() {
    this.inboxService.allMessageHeads(this.route.snapshot.paramMap.get('id')).subscribe(
      data => {
        console.log(data);
        this.allMessages = data;
      },
      error => {
        console.log(error);
      }
    );

  }

  getThreadMessages(id) {
    this.inboxService.threadMessages(id).subscribe(
      data => {
        this.threadMessages = data;
      },
      error => {
        console.log(error);
      }
    );
  }



  constructor(private inboxService: InboxService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.getAllMessageHeadsOfUser();
  }

}
