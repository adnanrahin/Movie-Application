import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-filter-category',
  templateUrl: './filter-category.component.html',
  styleUrls: ['./filter-category.component.css']
})
export class FilterCategoryComponent implements OnInit {

  @Input() list: any[];

  @Output() shareCheckedList = new EventEmitter();
  @Output() shareIndividualCheckedList = new EventEmitter();


  checkedList: any[];
  currentSelected: {};

  constructor() {
    this.checkedList = [];
  }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  getSelectedValue(status: boolean, value: string) {
    if (status) {
      this.checkedList.push(value);
    } else {
      // tslint:disable-next-line:prefer-const
      let index = this.checkedList.indexOf(value);
      this.checkedList.splice(index, 1);
    }

    this.currentSelected = {checked: status, name: value};

    // share checked list
    this.shareCheckedlist();

    // share individual selected item
    this.shareIndividualStatus();
  }

  // tslint:disable-next-line:typedef
  shareCheckedlist() {
    this.shareCheckedList.emit(this.checkedList);
  }

  // tslint:disable-next-line:typedef
  shareIndividualStatus() {
    this.shareIndividualCheckedList.emit(this.currentSelected);
  }


}
